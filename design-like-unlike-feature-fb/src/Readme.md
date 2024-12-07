# **Problem Statement**

Design like/unlike feature of facebook, when some one uploads a photo.
How do u notify to users who have already liked the photo.(Observer pattern)
10 million users like the photo at the same time, how do you handle such scenario.
Solution:(duplicate the photo instance in multiple servers based on load balance and do parallel reduction technique to do like++(lock like in each server) for each server and then broadcast the number of l ikes to other servers )


## **Solution**

## **Database Schema**

### **1. Photo Table**
| **Field**     | **Type**      | **Description**                    |
|---------------|---------------|-------------------------------------|
| `photo_id`    | Primary Key   | Unique identifier for the photo     |
| `user_id`     | Foreign Key   | User who uploaded the photo         |
| `like_count`  | Integer       | Denormalized count of total likes   |

---

### **2. Like Table** (optional, use Redis instead)
| **Field**     | **Type**      | **Description**                    |
|---------------|---------------|-------------------------------------|
| `like_id`     | Primary Key   | Unique identifier for the like      |
| `photo_id`    | Foreign Key   | Reference to the photo              |
| `user_id`     | Foreign Key   | The user who liked the photo        |
| `timestamp`   | DateTime      | When the like occurred              |


## System Architecture
|
```plaintext
User (App) 
    |
    v
API Gateway (AWS API Gateway, NGINX)
    |
    v
Load Balancer (NGINX, AWS ELB)
    |
    v
Like Service (multiple instances)
    |
    +--> Redis (for real-time like counts)
    |
    +--> Kafka (for asynchronous notifications)
    |
    +--> Database (for long-term storage of likes)
```
## **Cache Policy Options**

Here are the most commonly used cache policies and their applicability to the Like/Unlike system.

| **Policy**       | **Description**                                   | **Is it suitable?** | **Why/Why Not?**                                                                 |
|------------------|---------------------------------------------------|---------------------|----------------------------------------------------------------------------------|
| **Write-through** | Data is written to cache and DB simultaneously    | ❌                  | Too slow. Every "like" would require two writes (cache + DB)                     |
| **Write-back**    | Write to cache first, periodically sync to DB     | ✅                  | Best option. Real-time updates, batch DB writes for efficiency                   |
| **Write-around**  | Write directly to DB, cache is updated on read    | ❌                  | Increases read latency. Not suitable for real-time updates                       |
| **Cache-aside**   | App reads from cache, writes to DB, updates cache | ⚠️                  | Requires more effort, adds cache miss penalty                                    |
| **Read-through**  | If data is not in cache, it loads from DB         | ⚠️                  | Increases read latency, but good for less dynamic data                          |

### How Does Write-back Cache Work?
1. User likes a photo.
2. Update cache only (Redis) — the like count and the set of users who liked the photo.
3. Do not update the database immediately.
4. A background job (via a worker or scheduled task) runs every 10 seconds, reads from Redis, and updates the database.
5. If Redis crashes, the system can rebuild from the database during startup.


Yes, in a scalable and high-availability system like Facebook's Like/Unlike feature, multiple instances of Redis are typically used. Here's why and how they can be set up:

### Why Use Multiple Redis Instances?
**1. Scalability:**
A single Redis instance may not handle millions of concurrent requests or large amounts of data efficiently. Multiple instances distribute the load.

**2. Fault Tolerance:**
Using multiple instances ensures the system continues operating if one instance fails.

**3. High Availability:**
By configuring a Redis cluster, you can ensure failover support, making the system highly available.

**4. Data Sharding:**
Redis instances can be partitioned to handle different keys (e.g., photo likes can be sharded by photo_id).
Can use **Consistent Hashing** for sharding.

**5. Geographic Distribution:**
For global applications, multiple Redis instances can reduce latency by serving users from instances closer to their region.

### System Diagram

```plaintext
                     +-------------------+
                     |  Load Balancer    |
                     +-------------------+
                          |    |    |
              +-----------+    |    +------------+
              |                |                 |
   +----------------+  +----------------+  +----------------+
   |  Photo Service  |  |  Photo Service  |  |  Photo Service  |
   +----------------+  +----------------+  +----------------+
             |               |                     |
   +--------+---------------+---------------------+
   |                      Redis Cluster                      |
   |  Node 1  |  Node 2  |  Node 3  |  Node 4  |  Node 5  |  Node 6  |
   +------------------------------------------------------------+
        |                 |                   |
  (shard 1)         (shard 2)           (shard 3)

```


#### Question
what if 10 million likes on a particular photo, then all the hit will come to single shard, how to handle this?

#### Solution

- We can use Leader-Leader replication, hybrid with Leader-follower, set some
quorum factor. All the leaders will be in sync.
It is eventually consistent.
- Can have multiple leaders, and while returning the like count, aggregate the result
from all leaders. Latency will be little high.


#### References

https://chatgpt.com/c/6754109a-3934-800a-b2c3-6d0656babb41

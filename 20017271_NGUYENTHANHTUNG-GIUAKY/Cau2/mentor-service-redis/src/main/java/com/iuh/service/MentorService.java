package com.iuh.service;
import com.iuh.Model.Mentor;
import com.iuh.repository.MentorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorService {
    private HashOperations<String, String, Mentor> hashOperations;
    private RedisTemplate redisTemplate;

    public void MentorRepo(RedisTemplate<String, Mentor> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(Mentor product){
        hashOperations.put("MENTOR", product.getMentorId(), product);
    }

    public List<Mentor> findAll(){
        return hashOperations.values("MENTOR");
    }
}

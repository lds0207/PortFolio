package com.PortFoli.dong.springboot.service;

import com.PortFoli.dong.springboot.domain.posts.Posts;
import com.PortFoli.dong.springboot.domain.posts.PostsRepository;
import com.PortFoli.dong.springboot.web.dto.PostsResponseDto;
import com.PortFoli.dong.springboot.web.dto.PostsSaveRequestDto;
import com.PortFoli.dong.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        return  new PostsResponseDto(entity);
    }
}

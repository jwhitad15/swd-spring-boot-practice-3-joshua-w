package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Album;
import org.springframework.web.bind.annotation.*;
import com.example.springBoot2.repositories.AlbumRepository;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping("/albums")
    public Album getAllItems(@RequestBody Album album) {
        return (Album) albumRepository.findAll();
    }

    @GetMapping("/albums/{id}")
    public Album getItem(@PathVariable int albumId) {
        return (Album) albumRepository.findById(albumId).orElse(null);
    }

    @PostMapping("/albums")
    public Album addItem(@RequestBody Album album) {
        return (Album) albumRepository.save(album);
    }

    @PutMapping("/albums/{id}")
    public Album updateItem(@PathVariable int albumId, @RequestBody Album album) {
        album.setAlbumId(albumId);
        return albumRepository.save(album);
    }

    @DeleteMapping("/albums/{id}")
    public void deleteItem(@PathVariable int albumId) {
        albumRepository.deleteById(albumId);
    }

}

package org.lesson.bestoftheyear.controller;

import org.lesson.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @GetMapping
    public String songView(Model model){
        model.addAttribute("ListSongs",getSongList());
        return "songsView";
    }

    private List<Song> getSongList(){
        List<Song> songList = new ArrayList<>();
        songList.add(new Song(1,"Pain","Drake"));
        return songList;
    }

    @GetMapping("/{numberId}")
    public String songDetails(@RequestParam (name = "numberId" , defaultValue = "1") int songID,Model model){
        Song find = findSong(songID);
        model.addAttribute("findSong",find);
        return "songDetails";
    }

    public Song findSong(int idSong){
        Song find = new Song();
        for(Song element : getSongList()){
            if (idSong == element.getId()){
                find = element;
                break;
            }
        }
        return find;
    }

}

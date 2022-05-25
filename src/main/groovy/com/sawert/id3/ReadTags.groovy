package com.sawert.id3

import com.mpatric.mp3agic.ID3v1
import com.mpatric.mp3agic.ID3v2
import com.mpatric.mp3agic.Mp3File
import groovy.cli.picocli.CliBuilder

def cli = new CliBuilder(usage: 'ReadTags <file name>')
cli.h(longOpt: 'help', 'Display usage')
cli.f(longOpt: 'file', args: 1, 'File name')

def options = cli.parse(args)
def fileName = options.f

Mp3File mp3file = new Mp3File(fileName);

//if (mp3file.hasId3v1Tag()) {
//    println '\nID3v1 tags:'
//    ID3v1 id3v1Tag = mp3file.getId3v1Tag();
//    println("Track: " + id3v1Tag.getTrack());
//    println("Artist: " + id3v1Tag.getArtist());
//    println("Title: " + id3v1Tag.getTitle());
//    println("Album: " + id3v1Tag.getAlbum());
//    println("Year: " + id3v1Tag.getYear());
//    println("Genre: " + id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")");
//    println("Comment: " + id3v1Tag.getComment());
//}

if (mp3file.hasId3v2Tag()) {
    println '\nID3v2 tags:'
    ID3v2 id3v2Tag = mp3file.getId3v2Tag();
    println("Track: " + id3v2Tag.getTrack());
    println("Artist: " + id3v2Tag.getArtist());
    println("Title: " + id3v2Tag.getTitle());
    println("Album: " + id3v2Tag.getAlbum());
    println("Year: " + id3v2Tag.getYear());
    println("Genre: " + id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")");
    println("Comment: " + id3v2Tag.getComment());
    println("Lyrics: " + id3v2Tag.getLyrics());
    println("Composer: " + id3v2Tag.getComposer());
    println("Publisher: " + id3v2Tag.getPublisher());
    println("Original artist: " + id3v2Tag.getOriginalArtist());
    println("Album artist: " + id3v2Tag.getAlbumArtist());
    println("Copyright: " + id3v2Tag.getCopyright());
    println("URL: " + id3v2Tag.getUrl());
    println("Encoder: " + id3v2Tag.getEncoder());
    byte[] albumImageData = id3v2Tag.getAlbumImage();
    if (albumImageData != null) {
        println("Have album image data, length: " + albumImageData.length + " bytes");
        println("Album image mime type: " + id3v2Tag.getAlbumImageMimeType());
//        // Write image to file - can determine appropriate file extension from the mime type
//        RandomAccessFile file = new RandomAccessFile("/Users/bsawert/Temp/album-artwork", "rw");
//        file.write(albumImageData);
//        file.close();
    }
}

println '\nDone'

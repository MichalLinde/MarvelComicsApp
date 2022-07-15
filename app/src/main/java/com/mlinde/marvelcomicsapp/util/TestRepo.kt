package com.mlinde.marvelcomicsapp.util

import com.google.gson.Gson
import com.mlinde.marvelcomicsapp.data.*
import retrofit2.Response

class TestRepo(): RepositoryInterface {
    override suspend fun getComics(): ComicDataWrapper? {
        /*
        val url = Url("detail", "www")
        val creator = CreatorSummary("Jan", "writer")
        val creatorList = CreatorList(1, listOf(creator))
        val image = Image("png", "www")
        val thumbnail = Thumbnail("sdf", "sdfg")
        val comicBook = ComicBook(1,"asf","asd", thumbnail, listOf(image), creatorList, listOf(url))
        val comicDataContainer = ComicDataContainer(1,1,1, listOf(comicBook),1)
        val comicDataWrapper = ComicDataWrapper("asd","asd",1,"asd",comicDataContainer,"asd","asd")

        return Response.success(comicDataWrapper)

         */
        return null
    }

    override suspend fun searchComics(search: String): ComicDataWrapper {
//        val gson = Gson()
//        val json = "{\"code\":200,\"status\":\"Ok\",\"copyright\":\"©2022MARVEL\",\"attributionText\":\"DataprovidedbyMarvel.©2022MARVEL\",\"attributionHTML\":\"<ahref=\\\"http://marvel.com\\\">DataprovidedbyMarvel.©2022MARVEL</a>\",\"etag\":\"b3f9c956228ef0d2c065db1b802a0f18c93da36f\",\"data\":{\"offset\":0,\"limit\":20,\"total\":1,\"count\":1,\"results\":[{\"id\":101358,\"digitalId\":0,\"title\":\"AMAZINGSPIDER-MAN1FACSIMILEEDITION(2022)#1\",\"issueNumber\":1,\"variantDescription\":\"\",\"description\":null,\"modified\":\"2021-12-19T09:02:10-0500\",\"isbn\":\"\",\"upc\":\"75960620411300111\",\"diamondCode\":\"\",\"ean\":\"\",\"issn\":\"\",\"format\":\"Comic\",\"pageCount\":32,\"textObjects\":[],\"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/101358\",\"urls\":[{\"type\":\"detail\",\"url\":\"http://marvel.com/comics/issue/101358/amazing_spider-man_1_facsimile_edition_2022_1?utm_campaign=apiRef&utm_source=8e6eaff2babc82d749bb7e1f5586a85a\"},{\"type\":\"purchase\",\"url\":\"http://comicstore.marvel.com/AMAZING-SPIDER-MAN-1-FACSIMILE-EDITION-1/digital-comic/59119?utm_campaign=apiRef&utm_source=8e6eaff2babc82d749bb7e1f5586a85a\"}],\"series\":{\"resourceURI\":\"http://gateway.marvel.com/v1/public/series/34697\",\"name\":\"AMAZINGSPIDER-MAN1FACSIMILEEDITION(2022-Present)\"},\"variants\":[],\"collections\":[],\"collectedIssues\":[],\"dates\":[{\"type\":\"onsaleDate\",\"date\":\"2022-09-07T00:00:00-0400\"},{\"type\":\"focDate\",\"date\":\"2022-08-08T00:00:00-0400\"}],\"prices\":[{\"type\":\"printPrice\",\"price\":3.99}],\"thumbnail\":{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/5/d0/6202ecc5f2730\",\"extension\":\"jpg\"},\"images\":[{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/c/00/62cf1f4d01df4\",\"extension\":\"jpg\"}],\"creators\":{\"available\":1,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/101358/creators\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/creators/4430\",\"name\":\"JeffYoungquist\",\"role\":\"editor\"}],\"returned\":1},\"characters\":{\"available\":0,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/101358/characters\",\"items\":[],\"returned\":0},\"stories\":{\"available\":2,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/101358/stories\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/223817\",\"name\":\"coverfromAmazingSpider-Man1FacsimileEdition(2022)#1\",\"type\":\"cover\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/223818\",\"name\":\"storyfromAmazingSpider-Man1FacsimileEdition(2022)#1\",\"type\":\"interiorStory\"}],\"returned\":2},\"events\":{\"available\":0,\"collectionURI\":\"http://gateway.marvel.com/v1/public/comics/101358/events\",\"items\":[],\"returned\":0}}]}}"
//        val testData = gson.fromJson(json, ComicDataWrapper::class.java)
//        return  Response.success(testData)
        val url = Url("detail", "www")
        val creator = CreatorSummary("Jan", "writer")
        val creatorList = CreatorList(1, listOf(creator))
        val image = Image("png", "www")
        val thumbnail = Thumbnail("sdf", "sdfg")
        val comicBook = ComicBook(1,"asf","asd", thumbnail, listOf(image), creatorList, listOf(url))
        val comicDataContainer = ComicDataContainer(1,1,1, listOf(comicBook),1)
        val comicDataWrapper = ComicDataWrapper("asd","asd",1,"asd",comicDataContainer,"asd","asd")

        return comicDataWrapper
    }
}
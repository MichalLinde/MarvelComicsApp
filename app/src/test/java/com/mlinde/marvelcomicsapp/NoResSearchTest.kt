package com.mlinde.marvelcomicsapp

import com.mlinde.marvelcomicsapp.comicsList.ComicsListViewModel
import com.mlinde.marvelcomicsapp.data.*
import com.mlinde.marvelcomicsapp.searchList.SearchViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class NoResSearchTest: BaseTest() {

    val repo: ComicsRepository = mockk(relaxed = true)
    lateinit var testViewModel: SearchViewModel
    val searchString = "test"

//    val url = Url("detail", "www")
//    val creator = CreatorSummary("Jan", "writer")
//    val creatorList = CreatorList(1, listOf(creator))
//    val image = Image("png", "www")
//    val thumbnail = Thumbnail("sdf", "sdfg")
//    val comicBook = ComicBook(1, "asf", "asd", thumbnail, listOf(image), creatorList, listOf(url))
    val comicDataContainer = ComicDataContainer(0, 1, 1, emptyList(), 0)
    val comicDataWrapper =
        ComicDataWrapper("asd", "asd", 1, "asd", comicDataContainer, "asd", "asd")

    @Before
    override fun setup() {
        super.setup()
        testViewModel = SearchViewModel(repo)
    }

    @Test
    fun addition_isCorrect() = runTest {
        val data: ComicDataWrapper = comicDataWrapper
        coEvery { repo.searchComics(searchString) } returns data
        testViewModel.searchComics(searchString)
        delay(1)
        Assert.assertEquals(false, testViewModel.foundData.value)
    }
}
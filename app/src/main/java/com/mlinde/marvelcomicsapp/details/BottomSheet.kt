package com.mlinde.marvelcomicsapp.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.mlinde.marvelcomicsapp.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mlinde.marvelcomicsapp.data.ComicBook

@ExperimentalMaterialApi
@Composable
fun Details(comicBook: ComicBook) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )


    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(
            topStart = dimensionResource(id = R.dimen.find_more_button_corner_radius),
            topEnd = dimensionResource(id = R.dimen.find_more_button_corner_radius)
        ),
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.bottom_sheet_height))
                    .background(Color.Transparent),
                contentAlignment = Alignment.TopCenter

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_remove_24),
                    contentDescription = "Bottom sheet expand icon",
                )

                ComicBookDetails(comicBook = comicBook)

            }

            MoreButton(comicBook = comicBook)

        }, sheetPeekHeight = dimensionResource(id = R.dimen.bottom_sheet_peek)
    ) {

        BackgroundImage(comicBook = comicBook)

    }
}


@Composable
fun ComicBookDetails(comicBook: ComicBook){
    var authors = stringResource(id = R.string.no_author)
    if (comicBook.creators.items.isNotEmpty()) {
        authors = ""
        for (creator in comicBook.creators.items) {
            authors += " ${creator.name},"
        }
        authors.dropLast(1)
    }

    var description = stringResource(id = R.string.no_description)
    if (comicBook.description != null && comicBook.description != "") {
        description = comicBook.description
    }

    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(dimensionResource(id = R.dimen.sheet_column_padding))
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = comicBook.title,
            fontWeight = FontWeight.Bold,
            fontSize = dimensionResource(id = R.dimen.title_size).value.sp,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.sheet_spacer_height)))
        Text(
            text = authors,
            fontWeight = FontWeight.Light,
            fontSize = dimensionResource(id = R.dimen.author_size).value.sp,
            textAlign = TextAlign.Start,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.sheet_spacer_height)))
        Text(
            text = description,
            fontWeight = FontWeight.Normal,
            fontSize = dimensionResource(id = R.dimen.desc_size).value.sp,
            textAlign = TextAlign.Start
        )
    }
}


@Composable
fun MoreButton(comicBook: ComicBook){
    val uriHandler = LocalUriHandler.current
    val moreInfoUrl = comicBook.urls[0].url

    Box(
        Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.more_button_box_height))
            .background(Color.Transparent)
            .padding(bottom = dimensionResource(id = R.dimen.more_button_box_padding)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            onClick = {
                uriHandler.openUri(moreInfoUrl)
            },
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.more_button_box_height))
                .width(dimensionResource(id = R.dimen.more_button_width)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.find_more_button_corner_radius))
        ) {
            Text(
                text = "Find out more",
                color = Color.White,
                fontSize = dimensionResource(id = R.dimen.more_button_text_size).value.sp
            )
        }
    }
}


@Composable
fun BackgroundImage(comicBook: ComicBook){
    val imageUrl = comicBook.thumbnail.getPath().replace("http://", "https://")

    Column {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = "thumbnail",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .aspectRatio(ratio = 0.7f, matchHeightConstraintsFirst = true),
            fallback = painterResource(id = R.drawable.comic_book_cover)
        )
    }
}

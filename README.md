# MarvelComicsApp

## Installation
Marvel API has rate limit of 3000 calls per day, so before usage it's better to:
1. Go to https://developer.marvel.com and generate your API keys.
2. Paste them into Constants.kt file

## What does it do?
This app allows users to browse comics published by Marvel Comics.
Each search result contains:
- title
- authors
- description
- cover art
- link redirecting to official Marvel website with more info about this comic book

## Technologies
App is based on MVVM pattern and is dependent on LiveData

### 3rd party libraries
- Retrofit to fetch data from API
- Glide to load images from url to ImageView





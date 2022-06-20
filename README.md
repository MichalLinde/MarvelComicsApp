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

## Screenshots
<img src="https://user-images.githubusercontent.com/93143413/174459047-f869d9e1-ce1f-4c1a-b05f-a0585c2456e3.png" width="250">
<img src="https://user-images.githubusercontent.com/93143413/174504365-25d1d2a0-3624-4c28-85a6-5c8daf1712b3.png" width="250">
<img src="https://user-images.githubusercontent.com/93143413/174504393-c911ba2c-f813-4120-ba3c-d08c30b7dd99.png" width="250">
<img src="https://user-images.githubusercontent.com/93143413/174504412-39117584-35ea-48f5-aacd-b88eb4618f83.png" width="250">
<img src="https://user-images.githubusercontent.com/93143413/174459108-08e9313d-f788-4c47-a5c7-6729f47c9936.png" width="250">
<img src="https://user-images.githubusercontent.com/93143413/174459115-407d4a29-be38-4daa-8a34-b14f85c16227.png" width="250">






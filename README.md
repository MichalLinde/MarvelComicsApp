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
![image](https://user-images.githubusercontent.com/93143413/174459047-f869d9e1-ce1f-4c1a-b05f-a0585c2456e3.png)
![image](https://user-images.githubusercontent.com/93143413/174459059-bb485f3f-3204-402e-a00b-a7f8e1b3a69d.png)
![image](https://user-images.githubusercontent.com/93143413/174459090-52b6e71d-09ae-45b8-961c-fb144ac5225e.png)
![image](https://user-images.githubusercontent.com/93143413/174459101-90e961b2-9958-401e-a044-5003f53bf4a7.png)
![image](https://user-images.githubusercontent.com/93143413/174459108-08e9313d-f788-4c47-a5c7-6729f47c9936.png)
![image](https://user-images.githubusercontent.com/93143413/174459115-407d4a29-be38-4daa-8a34-b14f85c16227.png)





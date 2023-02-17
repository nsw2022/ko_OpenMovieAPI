package com.example.ko_openmovieapi

data class MovieRank constructor(val boxOfficeResult: MovieResult)

data class MovieResult constructor(val boxOfficType: String, val dailyBoxOfficeList: MutableList<MovieItem>)

data class MovieItem constructor(
    var rank : String,
    var movieNm:String,
    var openDt:String,
    var audiCnt:String
)

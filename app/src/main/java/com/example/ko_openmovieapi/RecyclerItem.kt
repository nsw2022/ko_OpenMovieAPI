package com.example.ko_openmovieapi

data class RecyclerItem constructor(
    val boxOfficeResult:RecyclerItemList
)

data class RecyclerItemList constructor(
    val dailyBoxOfficeList:MutableList<MovieDatas>
)

data class MovieDatas constructor(
    var rank : String,
    var movieNm : String,
    var openDt : String,
    var audiAcc : String
)

package org.example


fun gameOfLife(board:Array<Array<Int>>):Array<Array<Int>>{

}

fun runGameofLife(startingBoards:Array<Array<Array<Int>>>):Array<Array<Array<Int>>>{
    var ans = MutableList<Array<Array<Int>>> = mutableListOf()
    for (board in startingBoards){
        ans.add(gameOfLife(board))
    }
    return ans
}
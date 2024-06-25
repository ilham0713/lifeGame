package org.example
//most likely just going to keep the same rules for edges for now

val directions = arrayOf(
    arrayOf(-1, -1), 
    arrayOf(-1, 0), 
    arrayOf(-1, 1), 
    arrayOf(0, -1), 
    arrayOf(0, 1), 
    arrayOf(1, -1), 
    arrayOf(1, 0), 
    arrayOf(1, 1))

fun inBounds(x:Int, y:Int, board:Array<Array<Int>>): Boolean{
    val rows = board.size
    val cols = board[0].size
    if(x>=0&& y>=0 && x<rows && y<cols){
        return true
    }else{
        return false
    }
}

// fun isEdge(x:Int, y:Int, board:Array<Array<Int>>): Boolean{
//     val edge = board.size
//     val edge2 = board[0].size
//     if(x==0 || y==0 || x==edge || y==edge2){
//         return true
//     }else{
//         return false
//     }
// }

fun checkNeighbors(x:Int, y:Int, board: Array<Array<Int>>): Int{
    Int count = 0
    for(dir in directions){
        nx = dir[0]+x
        ny = dir[1]+y
        if(inBounds(nx, ny, board) && board[nr][nc] == 1){
            count++
        }
    }
    return count
}

// fun checkDeadNeighbors(x:Int, y:Int): Int{
//     /*
//     returns dead cells
    
//     */
//     return 0
// }



fun gameOfLife(board:Array<Array<Int>>):Array<Array<Int>>{
    var newBoard = board
    for (i in board.indices){
        for (j in board[0].indices){
            // if (isEdge(i, j, board)){

            // }else 
            liveNeighbors = checkNeighbors(i, j)
            //dead
            if(board[i][j]==0)(
                if(liveNeighbors==3){
                    newBoard[i][j] = 1
                }
            //live
            )else{
                if(liveNeighbors>3){
                    newBoard[i][j] = 0
                }
                if(liveNeighbors<2){
                    newBoard[i][j] = 0
                }
            }
        }
    }
    return newBoard
}

fun runGameofLife(startingBoards:Array<Array<Array<Int>>>):MutableList<Array<Array<Int>>>{
    var ans:MutableList<Array<Array<Int>>> = mutableListOf()
    for (board in startingBoards){
        ans.add(gameOfLife(board))
    }
    return ans
}
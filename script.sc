import scala.io.Source

:load utilities.sc
//load the text into a string
val myLines: Vector[String] = loadFile("text/clean_beyond_good_and_evil.txt")
//create a vector of all the caharachters in the text
val chars: Vector[Char] = myLines.mkString(" ").toVector
//take out the spaces
val noSpaces: Vector[Char] = chars.filter( _ != " ")
//creates a vector of each charachter and each time the char appears
val groupedChars: Vector[ (Char, Vector[Char]) ] = {
  noSpaces.groupBy( c => c ).toVector
}
//converts that vector into the characther and the number of times that charachter appears
/*
val charHistoUnsorted: Vector[ (Char, Int) ] = {
  groupedChars.map( c => {
    ( c._1, c._2.size )
  })
}
*/
//converts the last vector into the charachter and it's hex value
val charHexVal: Vector[ (Char, String) ] = {
  groupedChars.map( c => {
    ( c._1, c._1.toHexString )
  })
}
//val charHisto: Vector[ (Char, String) ] = charHexVal.sortBy( _._2 ).reverse

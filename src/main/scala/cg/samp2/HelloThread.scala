import scala.io.Source

object HelloThread extends  App {
   val d = new java.io.File("d:/inputData")
   val files = d.listFiles();
    files.foreach(f => {
        val thread = new Thread{
           override def run: Unit ={
             val data = Source.fromFile(f);
             println(data);
           }
        }
        thread.start();
    })

//  for(i <- 1 to 1000){
//    thread.start();
//  }
}

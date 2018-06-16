import com.github.dunnololda.scage.ScageLib._
import com.sksamuel.scrimage._
import com.sksamuel.scrimage.filter._
import com.sksamuel.scrimage.X11Colorlist._
import java.io.File._
import java.io._

import javax.imageio.ImageIO

object Main extends ScageScreenApp("Scage App", 1000, 640){




  backgroundColor = WHITE

   val photo1 = ImageIO.read(new File("resources/images/" + "dice.png"))

   var width = photo1.getWidth
   var height = photo1.getHeight


  var diceFile = new java.io.File("resources/images/" + "dice.png")
  var diceImage = Image(diceFile)

  var resultFile = new java.io.File("resources/images/result.png")
  diceImage.output(resultFile)

  var inProcessShow = com.github.dunnololda.scage.ScageLib.image("result.png", width, height, 0, 0, width, height)
  var imageInProcess = Image(resultFile)

    var name = "dice2.png"
  backgroundColor = WHITE

    //key(KEY_RIGHT)

  key(KEY_X, onKeyDown = {
    resultFile = new java.io.File("resources/images/result.png")
    imageInProcess = Image(resultFile)
    imageInProcess.flipX.output(resultFile)
    inProcessShow = com.github.dunnololda.scage.ScageLib.image("result.png", width, height, 0, 0, width, height)
  })

  key(KEY_Y, onKeyDown = {
    resultFile = new java.io.File("resources/images/result.png")
    imageInProcess = Image(resultFile)
    imageInProcess.flipY.output(resultFile)
    inProcessShow = com.github.dunnololda.scage.ScageLib.image("result.png", width, height, 0, 0, width, height)
  })

  key(KEY_R, onKeyDown = {
    resultFile = new java.io.File("resources/images/dice.png")
    imageInProcess = Image(resultFile)
    imageInProcess.output(new java.io.File("resources/images/result.png"))
    inProcessShow = com.github.dunnololda.scage.ScageLib.image("result.png", width, height, 0, 0, width, height)
  })

  key(KEY_B, onKeyDown = {
     resultFile = new java.io.File("resources/images/result.png")
     imageInProcess = Image(resultFile)
     imageInProcess.filter(filter.BlurFilter).output(resultFile)
   inProcessShow = com.github.dunnololda.scage.ScageLib.image("result.png", width, height, 0, 0, width, height)
})

  key(KEY_O, onKeyDown = {
     resultFile = new java.io.File("resources/images/result.png")
     imageInProcess = Image(resultFile)
     imageInProcess.filter(filter.ChromeFilter(1.0f, 1.0f)).output(resultFile)
   inProcessShow = com.github.dunnololda.scage.ScageLib.image("result.png", width, height, 0, 0, width, height)
})

  key(KEY_M, onKeyDown = {
     resultFile = new java.io.File("resources/images/result.png")
     imageInProcess = Image(resultFile)
     imageInProcess.filter(BrightnessFilter(5.0)).output(resultFile)
   inProcessShow = com.github.dunnololda.scage.ScageLib.image("result.png", width, height, 0, 0, width, height)
})

  key(KEY_F, onKeyDown = {
     resultFile = new java.io.File("resources/images/result.png")
     imageInProcess = Image(resultFile)
     imageInProcess.scaleTo(width - 20, height - 20).pad(10, Color.Black).output(resultFile)
 
    inProcessShow = com.github.dunnololda.scage.ScageLib.image("result.png", width, height, 0, 0, width, height)
})

     interface{
        print("options", Vec(770,450), RED)
        print("X - flipX", Vec(680,430), RED)
        print("Y - flipY", Vec(680,410), RED)
        print("B - blur filter", Vec(680,390), RED)
        print("M - bright filter", Vec(680,370), RED)
        print("R - reload", Vec(680,350), RED)
        print("F - frame", Vec(680,330), RED)
    }


    action(1){

}

render{
    drawDisplayList(inProcessShow, Vec(250,300))
}


}

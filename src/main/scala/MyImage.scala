import com.github.dunnololda.scage.ScageLib._
import com.sksamuel.scrimage._
import com.sksamuel.scrimage.filter._
import com.sksamuel.scrimage.X11Colorlist._
import java.io.File._
import java.io._
import javax.imageio.ImageIO

class MyImage(val name: String){

    val path = "resources/images/" + name + ".png"

    val file = new File(path)
    val image = ImageIO.read(file)
    var width = image.getWidth
    var height = image.getHeight

    var scageImage = com.github.dunnololda.scage.ScageLib.image(name + ".png", width, height, 0, 0, width, height)
    var scrimageImage = Image(new java.io.File(path))

    val resultName = name + "_result.png"
    val resultPath = "resources/images/" + resultName

    var resultFile = new File(resultPath)
    resultFile.createNewFile()
    scrimageImage.output(resultFile)

    var scageImageResult = com.github.dunnololda.scage.ScageLib.image(resultName, width, height, 0, 0, width, height)
    var scrimageImageResult = Image(new java.io.File(resultPath))


    def prepareImage() = {
        resultFile = new java.io.File(resultPath)
        scrimageImageResult = Image(resultFile)
    }

    def imageToScageFormat() = {
        scageImageResult = com.github.dunnololda.scage.ScageLib.image(resultName, width, height, 0, 0, width, height)
    }

    def flipX = {
        prepareImage()
        scrimageImageResult.flipX.output(resultFile)
        imageToScageFormat()
    }

    def flipY = {
        prepareImage()
        scrimageImageResult.flipY.output(resultFile)
        imageToScageFormat()
    }

    def frame = {
        prepareImage()
        scrimageImageResult.scaleTo(width - 20, height - 20).pad(10, Color.Black).output(resultFile)
        imageToScageFormat()
    }

    def blur = {
        prepareImage()
        scrimageImageResult.filter(filter.BlurFilter).output(resultFile)
        imageToScageFormat()
    }

    def bright = {
        prepareImage()
        scrimageImageResult.filter(BrightnessFilter(5.0)).output(resultFile)
        imageToScageFormat()
    }

     def chrome = {
        prepareImage()
        scrimageImageResult.filter(filter.ChromeFilter(1.0f, 1.0f)).output(resultFile)
        imageToScageFormat()
    }     

     def reload = {
        scrimageImage.output(resultFile)
        imageToScageFormat()
    }    

    def save = {
        prepareImage()
        scrimageImageResult.output(file)
        imageToScageFormat()
    }    

    
}


        

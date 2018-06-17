import com.github.dunnololda.scage.ScageLib._
import com.sksamuel.scrimage._
import com.sksamuel.scrimage.filter._
import com.sksamuel.scrimage.X11Colorlist._
import java.io.File._
import java.io._
import javax.imageio.ImageIO
import java.util.Scanner

class ImageAlbum(val path: String){

    val images = scala.collection.mutable.ArrayBuffer.empty[MyImage]
    var imagesCounter = 0

    for(file <- new File(path).listFiles) {

        val fileName = file.toString.split("/").last.split('.')(0)
        images += new MyImage(fileName)
        imagesCounter = imagesCounter + 1
    }
}

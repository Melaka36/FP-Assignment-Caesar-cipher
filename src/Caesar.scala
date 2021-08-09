import scala.io.StdIn.readLine

object Caesar extends App {
  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "

  val Encryption = (c:Char,key:Int,a:String) => (a((a.indexOf(c) + key)%a.size))

  val Decryption = (c:Char,key:Int,a:String) => (
    if((a.indexOf(c) - key) <0) a(a.size - math.abs((a.indexOf(c) - key)%a.size))
    else a((a.indexOf(c) - key)%a.size))

  val Cipher = (f:(Char, Int, String) => Char,c:Char,key:Int,a:String) => f(c:Char,key:Int,a:String)

  val key = 3
  print("Enter the string :");
  val source = readLine().toUpperCase();

  val encrypted_string = source.map(x => Cipher(Encryption,x,key,alphabet))
  println("Encrypted string	: " + encrypted_string)

  val decrypted_string = encrypted_string.map(y => Cipher(Decryption,y,key,alphabet))
  println("Decrypted string 	: " + decrypted_string)
}

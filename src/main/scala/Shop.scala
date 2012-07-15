
case class Product(prod_id: Int, prod_name: Option[String], prod_description: Option[String])

case class Catalog_Price_Index(prod_id:Int,qty: Int, price: Double)

case class Item(product_id:Int, qty:Int)

class Shop

/**
 *  // productList represents List of Products Eg.  List(Product(id, name, description)
 */

object Shop
{
  var productList:List[Product]= Nil
  def addNewProduct(p: Product) =   {Shop.productList =  Shop.productList ::: List(p)}
  def isItemExist(id:Int)=  productList.exists(s => s.prod_id == id)
}

/**
 *  // Catalog represents List of Catalog_Price_Index Eg.  List(Catalog_Price_Index(id, quantity, price)
 */
object Catalog
{
  var catalog : List[Catalog_Price_Index]=Nil
  def   setPrice(product_id:Int,qty:Int,price:Double) =   { if (Shop.isItemExist(product_id))Catalog.catalog = Catalog.catalog ::: List(Catalog_Price_Index(product_id,qty,price)) }
  def isCatalogEntryExist(id:Int) = catalog.exists(s => s.prod_id == id)
}


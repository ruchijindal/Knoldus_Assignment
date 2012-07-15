import collection.mutable.ListBuffer

/**
 * Created with IntelliJ IDEA.
 * User: Astar
 * Date: 7/13/12
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */


class Terminal {
   var trolley:List[Item]=Nil

  def scan(prod_id:Int)={
      if ((Shop.isItemExist(prod_id)) && (Catalog.isCatalogEntryExist(prod_id)))
          if (trolley.exists(A => A.product_id == prod_id))
              trolley= trolley map (A => if(A.product_id==prod_id){ Item(A.product_id,A.qty+1)} else A )
          else  trolley=trolley ::: List(Item(prod_id,1))
    else  println("Either Item #"+prod_id +" is Not Exist or Not Listed in Price Catalog")
  }
}
object Terminal
{
  def getPrice(id:Int,quantity:Int):Double =
  {
      val catalog = Catalog.catalog.filter(x => x.prod_id == id).sortBy(_.qty).reverse
      inject(catalog,quantity,(A,B)=> A/B*B)
  }

  // This method calculates the total price of all the scaned items in trolly.
  def getTrolleyPrice(c_list:List[Item]) ={
      c_list.foldLeft(0.0){(c,e)=>  c+ {getPrice(e.product_id,e.qty) } }
  }

  // inject is a higher order function used to calculate price of any item.
  def inject(lst:List[Catalog_Price_Index], initial:Int, operation:(Int,Int)=>Int )={
      var total = 0.0
      var quantity = initial
      lst foreach(element =>total+= {val q=operation(quantity,element.qty);
      quantity -= q ; q*(element.price/element.qty)})
      total }
}
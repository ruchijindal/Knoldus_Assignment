/**
 * Created with IntelliJ IDEA.
 * User: Astar
 * Date: 7/15/12
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 */

class Test_POS  extends org.scalatest.FunSuite {
  test("Add the Products in List") {
    Shop.addNewProduct(Product(1, Some("A"), Some("Imported Apples")))
    Shop.addNewProduct(Product(2, Some("B"), Some("Banana")))
    Shop.addNewProduct(Product(3, Some("C"), None))
    Shop.addNewProduct(Product(4, Some("D"), None))
    expect(4, "List Size Should not be zero") {
      Shop.productList.size
    }
  }

  //This is simple procedure to add the catalog entry.
  test("Set the price catalog") {
    Catalog.setPrice(1, 1, 2)
    Catalog.setPrice(1, 4, 7)
    Catalog.setPrice(2, 1, 12)
    Catalog.setPrice(3, 1, 1.25)
    Catalog.setPrice(3, 6, 6)
    Catalog.setPrice(4, 1, 15)
    expect(6, "Six Item Shoud be in catalog") {
      Catalog.catalog.size
    }
  }

  // Here We Have Four Product A,B,C,D with id's 1,2,3,4,
  // this case is trying to add one more catalog entry for product id 5 , which is not exist
  // so, process will not allowed to add any Catalog Entry without the product Entry.
  test("Add The price entry for the product which is not exist") {
    Catalog.setPrice(5, 1, 15)
    expect(7, "Six Item Shoud be in catalog") {
      Catalog.catalog.size
    }
    //Test fails because catalog doesn't allowed to add last catalog entry.
    //Still we have 6 Items in catalog List.
  }

  // Some of The Desired Use Cases Are as follows
  test("Test the Scan Process 1 (A,B,C,D,A,B,A,A ") {
    val terminal = new Terminal
    terminal.scan(1)
    terminal.scan(2)
    terminal.scan(3)
    terminal.scan(4)
    terminal.scan(1)
    terminal.scan(2)
    terminal.scan(1)
    terminal.scan(1)
    expect(32.40, "Total Price of scanned Items Should be 7.25") {
      Terminal.getTrolleyPrice(terminal.trolley)
    }
  }

  test("Test the Scan Process 2 (C,C,C,C,C,C,C ") {
    val terminal = new Terminal
    terminal.scan(3)
    terminal.scan(3)
    terminal.scan(3)
    terminal.scan(3)
    terminal.scan(3)
    terminal.scan(3)
    terminal.scan(3)
    expect(7.25, "Total Price of scanned Items Should be 7.25") {
      Terminal.getTrolleyPrice(terminal.trolley)
    }
  }

  test("Test the Scan Process 3 (A,B,C,D) ") {
    val terminal = new Terminal
    terminal.scan(1)
    terminal.scan(2)
    terminal.scan(3)
    terminal.scan(4)
    expect(15.40, "Total Price of scanned Items Should be 7.25") {
      Terminal.getTrolleyPrice(terminal.trolley)
    }
  }

}

(new Test_POS).execute()
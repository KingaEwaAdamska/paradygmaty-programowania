type ProductId = String

enum ProductType:
  case Unit, Kilogram

case class Product(
  code: ProductId,
  name: String,
  price: Double,
  productType: ProductType
)

type ReceiptItem = (ProductId, Double)
type Receipt = List[ReceiptItem]
type ProductDatabase = List[Product]

val example_db_1: ProductDatabase = List(
  Product("P001", "Apple", 2.5, ProductType.Kilogram),
  Product("P002", "Banana", 1.0, ProductType.Kilogram),
  Product("P003", "Notebook", 2.0, ProductType.Unit)
)

val example_db_empty: ProductDatabase = List()

val example_receipt_1: Receipt = List(
  ("P001", 2.0),
  ("P002", 3.4),
  ("P003", 1.0)
)

val example_receipt_empty: Receipt = List()

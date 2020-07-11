package aquarium

import kotlin.random.Random

fun main(args: Array<String>) {
    val book = Book("Facfulness", "Hans Rosling", 2018)
//
//    println(book.getTitleAndAuthor().toString())
//    println(book.getAll().toString())
//
//    val (title, author, year) = book.getAll()
//    println("Here is your book $title written by $author in $year")


//    val book1 = Book("title1", "author", 2020)
//    val book2 = Book("title2", "author", 2019)
//    val book3 = Book("title3", "author", 2018)
//
//    val allBooks = setOf(book1, book2, book3)
//    val library = mapOf("author" to allBooks)
//
//    val titleToFind = "Hamlet"
//    if (library.any { it.value.any { it.title.contains(titleToFind) }}) {
//        println("We have $titleToFind")
//    } else {
//        println("We don't have $titleToFind")
//    }
//
//    val moreBooks = mutableMapOf<String, Set<Book>>()
//
//    moreBooks.getOrPut("author") { setOf(book1) }


    book.pages = 350

    val puppy = Puppy()

    while (book.pages > 0) {
        println("Pages left: ${book.pages}")
        puppy.playWithBook(book)
    }
}

class Book(val title: String, val author: String, val year: Int) {

    var pages = 0

    var numberOfTimesBorrowed = 0

    companion object Constants {
        const val NUMBER_OF_BOOKS = 5
        const val BASE_URL = "https://books.com"
    }

    fun getTitleAndAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getAll(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBorrow(): Boolean {
        return numberOfTimesBorrowed < NUMBER_OF_BOOKS
    }

    fun printUrl() {
        val url = "${Constants.BASE_URL}/$title.html"
    }
}

fun Book.getWeight(): Double = pages * 1.5

fun Book.tornPages(tornPages: Int) {
    pages = pages - tornPages
}

class Puppy {

    fun playWithBook(book: Book) {
        book.tornPages(Random.nextInt(12))
    }
}

//open class Book(val title: String, val author: String) {
//
//    private var currentPage: Int = 0
//
//    open fun readPage() {
//        currentPage += 1
//        println("currentPage $currentPage")
//    }
//}
//
//class eBook(title: String, author: String, val format: String = "text"): Book(title, author) {
//
//    private var wordCount = 0
//
//    override fun readPage() {
//        wordCount += 250
//        println("wordCount $wordCount")
//    }
//}
//
//fun main(args: Array<String>) {
//    val book = Book("title", "author")
//    book.readPage()
//    book.readPage()
//    book.readPage()
//
//    val ebook = eBook("title", "author")
//    ebook.readPage()
//}
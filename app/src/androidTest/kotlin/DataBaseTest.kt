import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rendonsoft.beerappdemotest.commons.database.dao.BeerDao
import com.rendonsoft.beerappdemotest.commons.database.database.AppDataBase
import com.rendonsoft.beerappdemotest.commons.database.models.BeerDto
import java.io.IOException
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DataBaseTest {

    private lateinit var dataBase: AppDataBase
    private lateinit var beerDao: BeerDao

    private val beer = BeerDto(
            id = 0,
            page = 0,
            name = "Buzz",
            tagline = "A Real Bitter Experience.",
            first_brewed = "09/2007",
            description = "A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.",
            image_url = "https://images.punkapi.com/v2/keg.png",
            brewers_tips = "The earthy and floral aromas from the hops can be overpowering. Drop a little Cascade in at the end of the boil to lift the profile with a bit of citrus.",
            contributed_by = "Sam Mason <samjbmason>",
            attenuation_level = 76
    )

    private val beers = listOf(
            beer,
            beer.copy(id = 1),
            beer.copy(id = 2),
            beer.copy(id = 3),
    )

    @Before
    fun createDB() {
        dataBase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
                AppDataBase::class.java
        ).allowMainThreadQueries().build()

        beerDao = dataBase.beerDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        dataBase.close()
    }

    private fun insertBeers() {
        beers.forEach {
            beerDao.insertBeer(it)
        }
    }

    private fun insertNewPageBeers(page: Int) {
        beers.forEach {
            beerDao.insertBeer(it.copy(page = page))
        }
    }

    @Test
    fun dao_Insert_Beers() = runBlocking {
        insertBeers()
        val beersData = beerDao.getBeersByPage(0)
        assertEquals(beersData.size, beers.size)
    }


    @Test
    fun dao_Insert_And_Get_Beers_Page_2() = runBlocking {
        insertNewPageBeers(2)
        val beersData = beerDao.getBeersByPage(2)
        assertEquals(beersData.size, beers.size)
    }

    @Test
    fun dao_Insert_And_Get_Beers_Id_1() = runBlocking {
        insertBeers()
        val beer = beerDao.getBeersById(1)
        assertEquals(beer.id, beers[1].id)
    }

    @Test
    fun dao_Delete_Beers() = runBlocking {
        insertBeers()
        beerDao.deleteBeers()
        val beersData = beerDao.getBeersByPage(0)
        assert(beersData.isEmpty())
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}

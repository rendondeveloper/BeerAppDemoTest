import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rendonsoft.beerappdemotest.commons.database.database.AppDataBase
import com.rendonsoft.beerappdemotest.commons.database.models.BeerDto
import com.rendonsoft.beerappdemotest.feature.home.data.dataSource.HomeBeerLocalDataSource
import com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.dataSource.local.HomeBeerLocalDataSourceImpl
import com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.dataSource.local.mapper.BeerDtoToBeerModelMapper
import java.io.IOException
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class LocalDataSourceTest {

    private lateinit var dataBase: AppDataBase
    private lateinit var homeBeerLocalDataSource: HomeBeerLocalDataSource

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
    ).toTypedArray()

    @Before
    fun createDB() {
        dataBase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
                AppDataBase::class.java
        ).allowMainThreadQueries().build()

        homeBeerLocalDataSource = HomeBeerLocalDataSourceImpl(dataBase.beerDao(), BeerDtoToBeerModelMapper())
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        dataBase.close()
    }

    private suspend fun insertOneBeer() {
        homeBeerLocalDataSource.saveBeers(beer)
    }

    private suspend fun insertBeers() {
        homeBeerLocalDataSource.saveBeers(beers = beers)
    }

    private suspend fun insertNewPageBeers(page: Int) {
        beers.forEach {
            homeBeerLocalDataSource.saveBeers( it.copy(page = page))
        }
    }

    @Test
    fun dao_Insert_One_Beer() = runBlocking {
        insertOneBeer()
        val beersData = homeBeerLocalDataSource.getBeersByPage(0)
        assertEquals(beersData.size, 1)
    }

    @Test
    fun dao_Insert_Beers() = runBlocking {
        insertBeers()
        val beersData = homeBeerLocalDataSource.getBeersByPage(0)
        assertEquals(beersData.size, beers.size)
    }

    @Test
    fun dao_Insert_Beers_By_Page() = runBlocking {
        insertNewPageBeers(2)
        val beersData = homeBeerLocalDataSource.getBeersByPage(2)
        assertEquals(beersData.size, beers.size)
    }

    @Test
    fun dao_Insert_Beers_By_Beer_Id() = runBlocking {
        insertNewPageBeers(3)
        val beerData = homeBeerLocalDataSource.getBeerById(0)
        assertEquals(beerData.id, beers.first().id)
    }

}

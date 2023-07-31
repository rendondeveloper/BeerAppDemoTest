import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.gson.Gson
import com.rendonsoft.beerappdemotest.commons.network.Network
import com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.api.BeerApi
import com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.config.response.Beer
import com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.config.response.BeerResponse
import java.io.IOException
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RemoteDataSourceTest {

    private val mockWebServer = MockWebServer()

    private lateinit var network: BeerApi

    private lateinit var mockResponse: MockResponse

    private val beer = Beer(
            id = 0,
            page = 0,
            name = "Buzz",
            tagline = "A Real Bitter Experience.",
            first_brewed = "09/2007",
            description = "A light, crisp and bitter IPA brewed with English and American hops. A small batch brewed only once.",
            image_url = "https://images.punkapi.com/v2/keg.png",
            brewers_tips = "The earthy and floral aromas from the hops can be overpowering. Drop a little Cascade in at the end of the boil to lift the profile with a bit of citrus.",
            contributed_by = "Sam Mason <samjbmason>",
            attenuation_level = 76.0
    )

    @After
    fun closeDb() {
        mockWebServer.shutdown()
    }

    @Test
    fun get_Remote_One_Beer() {
        val response = BeerResponse(beers = arrayListOf(beer))
        mockResponse = MockResponse()
        mockResponse.setBody(Gson().toJson(response))
        network = Network(url = mockWebServer.url("/").toString())
                .getInstance()
                .create(BeerApi::class.java)

        mockWebServer.enqueue(mockResponse)
        runBlocking {
            val beersData = network.getBeersAsync(0).await()
            assertEquals(beersData.body()!!.size, response.beers.size)
        }
    }

    @Test
    fun get_Remote_List_Beer() {
        val response = BeerResponse(beers = arrayListOf( beer,
                beer.copy(id = 1),
                beer.copy(id = 2),
                beer.copy(id = 3),))
        mockResponse = MockResponse()
        mockResponse.setBody(Gson().toJson(response))
        network = Network(url = mockWebServer.url("/").toString())
                .getInstance()
                .create(BeerApi::class.java)

        mockWebServer.enqueue(mockResponse)
        runBlocking {
            val beersData = network.getBeersAsync(0).await()
            assertEquals(beersData.body()!!.size, response.beers.size)
        }
    }

}

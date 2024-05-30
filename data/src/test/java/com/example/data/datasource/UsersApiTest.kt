import com.example.data.datasource.UsersApi
import com.example.data.util.UtilTests
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class UsersApiTest {

    @Mock
    private lateinit var usersApi: UsersApi

    @Before
    fun setUp() {
        usersApi = mock(UsersApi::class.java)
    }

    @Test
    fun getUsersReturnsExpectedResult() = runTest {
        val expectedResponse = UtilTests.dummyResponseData
        `when`(usersApi.getUsers()).thenReturn(expectedResponse)

        val actualResponse = usersApi.getUsers()

        assertEquals(expectedResponse, actualResponse)
    }
}
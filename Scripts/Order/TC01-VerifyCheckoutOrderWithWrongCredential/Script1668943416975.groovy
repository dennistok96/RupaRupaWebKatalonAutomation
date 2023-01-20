import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CucumberKW.comment('Story: Verify checkout order functionality')

CucumberKW.comment('When the user click on rumah tangga category')

WebUI.click(findTestObject('RupaRupa/HomePage/RumahTanggaCategoryMenuTextField'))

WebUI.waitForElementPresent(findTestObject('RupaRupa/RumahTanggaCategoryLandingPage/DekorasiRumahTextLabel'), GlobalVariable.timeout)

CucumberKW.comment('And the user select on buy 1 get 1 promo')

WebUI.scrollToElement(findTestObject('RupaRupa/RumahTanggaCategoryLandingPage/LokasiTextLabel'), GlobalVariable.timeout)

promoTypeLocalVar = 'label-Buy_1_Get_1'

WebUI.click(findTestObject('RupaRupa/RumahTanggaCategoryLandingPage/PromoCategoryCheckbox', [('promoType') : promoTypeLocalVar]))

CucumberKW.comment('And the user select on new arrival products')

typeLocalVar = 'newArrival'

WebUI.click(findTestObject('RupaRupa/RumahTanggaCategoryLandingPage/SortedDropdown', [('type') : typeLocalVar]))

CucumberKW.comment('And the user select on first product')

productIndexLocalVar = 1

WebUI.click(findTestObject('RupaRupa/RumahTanggaCategoryLandingPage/Product', [('index') : productIndexLocalVar]))

CucumberKW.comment('And the user click on tambah ke keranjang button')

WebUI.click(findTestObject('RupaRupa/ProductDetailPage/CicilanPopupButton'))

WebUI.waitForElementNotHasAttribute(findTestObject('RupaRupa/ProductDetailPage/TambahKeranjangButton'), 'disabled', GlobalVariable.timeout)

WebUI.click(findTestObject('RupaRupa/ProductDetailPage/TambahKeranjangButton'))

WebUI.click(findTestObject('RupaRupa/ProductDetailPage/PilihMetodePemesananButton'))

CucumberKW.comment('And the user click on lanjut ke keranjang button')

WebUI.click(findTestObject('RupaRupa/ProductDetailPage/LanjutKeKeranjangButton'))

WebUI.waitForElementVisible(findTestObject('RupaRupa/ProductCartPage/CatatanPopupButton'), GlobalVariable.timeout)

WebUI.click(findTestObject('RupaRupa/ProductCartPage/CatatanPopupButton'))

WebUI.click(findTestObject('RupaRupa/ProductCartPage/LanjutKePembayaranButton'))

CucumberKW.comment('And the user clicks on sign in section')

WebUI.waitForElementPresent(findTestObject('RupaRupa/ProductCheckoutPage/SignInButton'), GlobalVariable.timeout)

CucumberKW.comment('And the user fill on random email and password at the sign in form')

WebUI.sendKeys(findTestObject('RupaRupa/ProductCheckoutPage/emailTextField'), GlobalVariable.email)

WebUI.sendKeys(findTestObject('RupaRupa/ProductCheckoutPage/passwordTextField'), GlobalVariable.password)

WebUI.click(findTestObject('RupaRupa/ProductCheckoutPage/SignInButton'))

CucumberKW.comment('Then the login error message should be displayed')

WebUI.waitForElementPresent(findTestObject('RupaRupa/ProductCheckoutPage/LoginErrorMessage'), GlobalVariable.timeout)

WebUI.verifyElementText(findTestObject('RupaRupa/ProductCheckoutPage/LoginErrorMessage'), 'Alamat email atau nomor telepon dan password Anda salah')

@com.kms.katalon.core.annotation.SetUp
def Setup() {
    CucumberKW.comment('Given that user has launched browser')

    WebUI.openBrowser('')

    WebUI.deleteAllCookies()

    WebUI.maximizeWindow()

    CucumberKW.comment('And the user navigates to ruparupa.com')

    WebUI.navigateToUrl(GlobalVariable.url)

    WebUI.waitForPageLoad(GlobalVariable.timeout)
}

@com.kms.katalon.core.annotation.TearDown
def Teardown() {
    CucumberKW.comment('And the browser is closed')

    WebUI.closeBrowser()
}


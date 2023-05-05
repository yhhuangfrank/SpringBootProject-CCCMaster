<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html lang="en">

    <head>
      <meta charset="utf-8">
      <meta content="width=device-width, initial-scale=1.0" name="viewport">

      <title>山西達人-常見問題</title>
      <meta content="" name="description">
      <meta content="" name="keywords">

      <c:set var="contextRoot" value="${pageContext.request.contextPath}" />

      <!-- Favicons -->
      <link href="${contextRoot}/styles/front/assets/img/favicon.png" rel="icon">
      <link href="${contextRoot}/styles/front/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

      <!-- Google Fonts -->
      <link
        href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
        rel="stylesheet">

      <!-- Vendor CSS Files -->
      <link href="${contextRoot}/styles/front/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
      <link href="${contextRoot}/styles/front/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextRoot}/styles/front/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
      <link href="${contextRoot}/styles/front/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
      <link href="${contextRoot}/styles/front/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
      <link href="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

      <!-- Template Main CSS File -->
      <link href="${contextRoot}/styles/front/assets/css/style.css" rel="stylesheet">

      <!-- =======================================================
    * Template Name: Eterna
    * Updated: Mar 10 2023 with Bootstrap v5.2.3
    * Template URL: https://bootstrapmade.com/eterna-free-multipurpose-bootstrap-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
    </head>

    <body>

     

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/topbar.jsp"/>

<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/header.jsp"/>
      <main id="main">

        <!-- ======= Breadcrumbs ======= -->
        <section id="breadcrumbs" class="breadcrumbs">
          <div class="container">

            <ol>
              <li><a href="${contextRoot}/">首頁</a></li>
              <li>聯絡客服</li>
              <li>常見問題</li>
            </ol>
            <h2>常見問題</h2>

          </div>
        </section><!-- End Breadcrumbs -->

        <!-- ======= Services Section ======= -->
        <section id="services" class="services">
          <div class="container">

            <div class="row">
              <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bxl-dribbble"></i></div>
                  <h4><a href="${contextRoot}/Service/common">熱門問題</a></h4>
                </div>
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4><a href="${contextRoot}/Service/common/order">訂購付款</a></h4>
                  <p></p>
                </div>
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4><a href="${contextRoot}/Service/common/delivery">配送說明</a></h4>
                  <p></p>
                </div>
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4><a href="/Service/common/Refund">售後退款</a></h4>
                  <p></p>
                </div>
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4><a href="/Service/common/discount">購物優惠</a></h4>
                  <p></p>
                </div>
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4><a href="/Service/common/Activity">活動相關</a></h4>
                  <p></p>
                </div>
                <div class="icon-box">
                  <div class="icon" style="margin-right:50px;margin-left:50px;"><i class="bx bx-file"></i></div>
                  <h4><a href="/Service/common/Account">會員帳號</a></h4>
                  <p></p>
                </div>
              </div>

            </div>
          </div>

        </section><!-- End Services Section -->

        <!-- ======= Our Skills Section ======= -->
        <section id="skills" class="skills">
          <div class="container">

            <div class="section-title">
              <h2>訂購付款</h2>
            </div>



            <!-- Accordion without outline borders -->
            <div class="accordion" id="accordionExample">
              <div class="accordion-item">
                <h2 class="accordion-header" id="headingOne">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                    <strong>Q1、購物中心提供那些付款方式?</strong>
                  </button>
                </h2>
                <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne"
                  data-bs-parent="#accordionExample" style="background-color:#FFFACD;">
                  <div class="accordion-body">
                    <strong>目前山西達人僅提供綠界付款</strong>
                  </div>
                </div>
              </div>
              <div class="accordion-item">
                <h2 class="accordion-header" id="headingTwo">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    <strong>Q2、我一定要成為會員，才能在山西達人購物中訂購商品嗎？</strong>
                  </button>
                </h2>
                <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo"
                  data-bs-parent="#accordionExample" style="background-color:#FFFACD;">
                  <div class="accordion-body">
                    <strong>是的，為了保障您的權益，需要成為會員才能在山西達人購物購買商品，此外，成為會員才能享有購物行銷活動及各種優惠活動哦！</strong>
                  </div>
                </div>
              </div>
              <div class="accordion-item">
                <h2 class="accordion-header" id="headingThree">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    <strong>Q3、購物須知</strong>
                  </button>
                </h2>
                <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree"
                  data-bs-parent="#accordionExample" style="background-color:#FFFACD;">
                  <div class="accordion-body">
                    <strong>山西達人購物中心購物須知<br>

                      感謝您向 山西達人中心訂購商品，為維護您的權益，請仔細閱讀下述說明：<br>

                      1.本購物須知是山西達人服務條款的補充條款，當您使用山西達人中心時，即表示您已閱讀、瞭解並同意接受本購物須知所訂之所有內容。本須知得隨時修訂並公告於山西達人中心上，修訂後之內容自公告時起生效。<br>

                      2.若您未滿十八歲，您應於您的家長（或監護人）閱讀、瞭解並同意本購物須知之所有內容及其後修改變更後，方得使用或繼續使用山西達人中心。當您使用或繼續使用山西達人中心時，即推定您的家長（或監護人）已閱讀、瞭解並同意接受本購物須知之所有內容及其後修改變更。<br>

                      3.當您使用或繼續使用山西達人中心時，即表示您同意以電子文件作為意思表示之方法。<br>

                      4.
                      請注意，當您訂購多筆商品並選擇以信用卡或信用卡分期付款時，山西達人購物中心將就各筆訂單分別向銀行取得授權，並非代表您已經付款，也不代表交易已經完成或契約已經成立，山西達人中心仍須確認交易條件無誤、商品仍有庫存或服務仍可提供，且無其他山西達人中心無法接受訂單之情形。於確認無上述問題前，山西達人中心不會請領信用卡交易款項，該筆交易金額也不諱出現在您的信用卡帳單中，直到山西達人確認接受訂單為止。如因信用卡額度不足或系統因素等問題，導致發生當次訂購之商品無法全部取得銀行授權之情形，山西達人購物中心將會就已成功取得授權部分之商品繼續處理您的訂單，若您就其他商品仍有需要時，請重新訂購。但若當次訂購享有跨產品優惠、滿額
                      / 滿件優惠者，
                      山西達人購物中心將視為授權全部失敗，請您重新選擇付款方式。另外，使用信用卡分期付款，該服務係由您的信用卡發卡機構提供，債權債務關係係存在您與信用卡發卡機構間，除相關網頁有特別標示外，其所支付之利息、計算方式、是否另有信用保險或保證人之設定或涉入，均依據您與信用卡發卡機構間之相關約定內容辦理，請您自行查閱並注意與信用卡發卡機構間之相關約定。<br>

                      5.當您完成商品訂購程序後，山西達人中心將自動發送電子郵件於您所留存的電子郵件信箱，通知您山西達人中心已經收到您的訂購需求。<br>

                      6.
                      請注意，山西達人中心即使收到您的訂購需求，亦不代表交易已經完成或契約已經成立，山西達人仍須確認交易條件無誤、商品仍有庫存或服務仍可提供，且無其他山西達人中心無法接受訂單之情形後，始直接通知配合廠商出貨。如交易條件有誤、商品無存貨、服務無法提供，或有其他山西達人無法接受訂單之情形，山西達人中心將拒絕接受您的訂單。如山西達人中心可接受您的訂單，商品寄出時我們會寄一封出貨通知信給您。您可隨時至「訂單查詢」確認訂單最新資料，並可點選該筆訂單的「訂單明細」確認付款/訂購/出貨資訊等資料。<br>

                      7.為保護您的權益，在山西達人中心之配合廠商出貨之前，您都可以申請取消訂單（但若您的商品為訂製商品，且已經製作，您將無法取消訂單）。但若當次訂購享有跨產品或滿額/滿件優惠者，若有需要取消或退貨時，須將當次訂購之商品訂單全部取消或退貨。<br>

                      8.根據消費者保護法之規定，除商品有消費者保護法第十九條第一項但書所規定之合理例外情事外，將提供您享有商品到貨15天猶豫期隨時解約退貨之權益，但提醒您注意，商品退貨時必須回復原狀，亦即必須回復至您收到商品時的原始狀態
                      ( 包含主機、附件、內外包裝、隨機文件、贈品等）。<br>
                      此外，下列情形可能影響您的退貨權限：</strong><br>
                    (1)隨商品已附上相同之試用品，或在收到影音光碟及軟體前已提供您試聽、試用之機會。<br>
                    (2)在不影響您檢查商品情形下，您將商品包裝毀損、封條移除、吊牌拆除、貼膠移除或標籤拆除等情形。<br>
                    (3)在您收到商品之前，已提供您檢查商品之機會。<br>
                    (4)其他逾越檢查之必要或可歸責於您之事由，致商品有毀損、滅失或變更者。<br>

                    <strong> 8-1.合理例外情事，係指經山西達人購物中心告知您商品有下列情形：</strong><br>
                    (1)依消費者要求所為之客製化給付（如：消費者提供相片印製之商品、依指示刻製之印章、依身材縫製之衣服等）<br>
                    (2)經消費者拆封之影音商品或電腦軟體。<br>
                    (3)非以有形媒介提供之數位內容（如：電子書），或一經提供即為完成之線上服務（如：線上掃毒），經消費者事先同意始提供者。<br>
                    (4)其餘定型化契約規範之商品者（如：藝文展覽票券、藝文表演票券、線上遊戲等）。<br>
                    <strong>
                      8-2.行政院消費者保護處中華民國八十七年十一月五日台八十七消保法字第○一二五○號函：「民眾購買商品，如其目的主要供執行業務或投入生產使用，並非單純供最終消費使用者，核與消費者保護法第二條有關消費者及消費關係之定義未合，尚無消費者保護法之適用」。因山西達人中心銷售商品對象為消費者，如有相關事證認定您並非最終消費使用者（包含但不限於您大量購買商品無法合理解釋為自用），山西達人中心有權拒絕提供您其他消費者得享有之優惠（包含但不限於提供購物金與超贈點或其他回饋、快速到貨遲到申訴、鑑賞期等），並請至本中心大宗採購專區進行採購。如果您違反此規定，山西達人中心有權於您循上述規定辦理前，暫停您原以消費者身分註冊之帳號使用。<br>
                      9.取消訂單或是退貨之退款，若符合退款條件時，山西達人中心將會為您進行退款作業。信用卡線上付款，將直接刷退至您當初使用來付款的信用卡帳戶中，且將於您的下一期信用卡帳單中顯示。若您所使用的付款方式為ATM轉帳/超商付款/超商取貨/貨到付款時，請您在填寫退貨單時，提供正確的退款帳號資料，退款將匯入您指定的帳戶。退款時，您所支出之轉帳手續費，山西達人中心將不予退費。<br>
                      10.您所訂購的所有商品，其品質、保固、維修及售後服務等事項，皆是由各該商品的原廠、代理商、進口商、經銷商、商品提供者等，依照其所制定的條件，負責對您提供品質承諾、保固、維修及售後服務等，若您仍有任何問題，您可以直接與上開廠商聯絡，您可於「訂單查詢」點選該筆訂單的「我要維修」確認出貨廠商的聯絡資料，亦可直接與山西達人中心客服人員聯絡，山西達人中心將協助您解決相關問題。<br>
                      11.商品交易頁面呈現之商品名稱、價格、內容、規格、型號及其他相關資訊，為契約之一部分。山西達人中心網頁上之商品相關資訊係由配合廠商提供，山西達人中心會盡力維護相關資料的正確性，但山西達人購物中心不以任何明示或默示的方式保證所有出現在網頁上、或相關訊息上的資料均為完整、正確、即時的資訊。這代表：</strong><br>
                    (1)如果商品或服務銷售網頁及訂購流程中之訂購數量上限，超過相關商品或服務之可訂購數量者，山西達人中心僅依據該數量上限出貨。<br>
                    (2)如果相關商品或服務的規格、圖片或說明有誤，仍以原廠、代理商、進口商、經銷商或服務提供者的資料為準。<br>
                    (3)如果網頁或相關訊息上標示的價格有誤，且標示價格較正常售價高者，山西達人中心僅會向您收取正常之正確售價；如標示價格較正常售價低者，山西達人中心有權拒絕接受您的訂單。<br>
                    (4)如有上述交易條件錯誤之情形，山西達人中心將於確認網頁內容與正常交易條件後，拒絕接受您的訂單。<br><br>
                    <strong>山西達人中心將依照個人資料保護法令相關規定保護您的個人資料，相關隱私權保護政策，請參考山西達人隱私權保護政策。<br>
                      13.山西達人中心將於知悉您的帳號密碼遭冒用時，立即停止該帳號所生交易之處理及後續利用。 14.山西達人中心與您交易所使用之電腦系統將確保具有符合一般可合理期待之安全性。<br>
                      14.若山西達人中心依法或依約須對您負擔賠償或補償責任時，山西達人中心之賠償或補償責任以有爭議之該筆交易之實收金額為上限。<br>
                      15.山西達人中心對於任何因該筆交易所生之其他損害（包含但不限於間接損失），不負任何補償或賠償責任。 <br>
                      16.本購物須知如有疑義時，應為有利於消費者之解釋。<br>
                      17.山西達人中心上之所有服務說明均為本購物須知之一部分，本須知未規範之事宜，請詳見相關事項及個別商品之網頁說明及其他的服務說明。如您有消費申訴或爭議，皆可透過客服中心或「訂單查詢」進行發問，山西達人中心客服人員將儘速為您提供服務。<br>
                      18.準據法：本購物須知之解釋與適用，以及與本購物須知有關的爭議，均應依照中華民國法律予以處理。</strong><br>

                  </div>
                </div>
              </div>
              <div class="accordion-item">
                <h2 class="accordion-header" id="headingFour">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                    <strong>Q4、發票問題</strong>
                  </button>
                </h2>
                <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour"
                  data-bs-parent="#accordionExample" style="background-color:#FFFACD;">
                  <div class="accordion-body">
                    <strong>會提供發票給我嗎？</strong><br>
                    1.本網站將於訂單付款完成、商品出貨後開立電子發票並寄Email通知您。<br>
                    ●在購物中心消費，若使用優惠活動全額折抵，實際付款金額為0元，將不會開立發票，會有購買證明供保固使用。若您需要發票參加活動或報帳，建議您勿使用全額折抵，以免影響您的權益。<br>
                    ●若您訂購時選擇公司戶電子發票，請於商品出貨發票開立後次日( 超商取貨訂單請於取貨後次日)，至本網站下載列印電子發票證明聯，即可交付貴公司報帳。<br>
                    購物中心訂單：請至【購物中心】>【我的帳戶】>【訂單查詢】>【發票】下載列印。<br>
                    2.於本網站消費開立之統一發票資訊，將於期限內上傳至整合服務平台留存，您可於發票開立後48小時至財政部電子發票整合服務平台查詢。<br><br>

                    <strong>個人電子發票如何索取紙本？</strong><br>
                    山西達人暫未提供紙本發票<br><br>

                    <strong>怎麼知道發票是否中獎?中獎發票是否會寄給我?</strong><br>
                    統一發票在單月25日開獎後，將由財政部電子發票整合平台統一進行對獎作業，中獎發票領取方式依發票載具類型及歸戶狀態區分如下：<br>
                    1.個人電子發票<br>
                    ●使用手機條碼載具或自然人憑證載具：由財政部電子發票整合平台通知中獎事宜，請至該平台查詢。<br>
                    ●使用山西達人會員載具且會員載具已歸戶：由財政部電子發票整合平台通知中獎事宜，請至該平台查詢。<br>
                    購物中心會員載具未歸戶中獎發票，可至【我的帳戶】>【訂單查詢】>【發票】查看中獎資訊。<br>
                    2.捐贈發票<br>
                    ●由財政部電子發票整合服務平台進行對獎及匯入指定捐贈單位帳戶。<br>

                    <strong>退貨時要將發票寄回嗎?</strong><br>
                    ●若您有索取個人紙本發票，辦理退貨請單獨將發票(或折讓簽名)寄回本網站：台北郵政191-88號信箱 Yahoo奇摩電子商務營運管理部收<br>
                    ●若您的訂單為公司戶電子發票，無需將已下載列印的發票寄回，請於退貨完成後至本網站下載列印折讓證明單交付貴公司報帳即可。<br>
                    提醒您，請於申報期限前列印折讓證明單交付貴公司報帳，以免耽誤申報時效。<br>
                    購物中心訂單：請至【購物中心】>【我的帳戶】>【訂單查詢】>【發票】下載列印。<br>
                  </div>
                </div>
              </div>
              <!-- 我是分隔線 -->

            </div>
          </div><!-- End Accordion without outline borders -->

        </section><!-- End Our Skills Section -->

      </main><!-- End #main -->
    
<jsp:include page="${contextRoot}/WEB-INF/views/front/layouts/footer.jsp"/>


      <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
          class="bi bi-arrow-up-short"></i></a>

      <!-- Vendor JS Files -->
      <script src="${contextRoot}/styles/front/assets/vendor/purecounter/purecounter_vanilla.js"></script>
      <script src="${contextRoot}/styles/front/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
      <script src="${contextRoot}/styles/front/assets/vendor/glightbox/js/glightbox.min.js"></script>
      <script src="${contextRoot}/styles/front/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
      <script src="${contextRoot}/styles/front/assets/vendor/swiper/swiper-bundle.min.js"></script>
      <script src="${contextRoot}/styles/front/assets/vendor/waypoints/noframework.waypoints.js"></script>
      <script src="${contextRoot}/styles/front/assets/vendor/php-email-form/validate.js"></script>
      <!-- Template Main JS File -->
      <script src="${contextRoot}/styles/front/assets/js/main.js"></script>

    </body>

    </html>
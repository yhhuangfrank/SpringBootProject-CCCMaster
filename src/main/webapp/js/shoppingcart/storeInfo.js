
const cities = document.querySelector("#city")
const addre = document.querySelector("#storeaddress")
$(document).ready(function(){
	$.getJSON(`../../json/store.json`,function(res){
		getDefault();
		
		function findcities(){
			let options = ``;
			for(var i=0;i<res.length;i++){
			options += `
			<option value="${i}">${res[i].city_name}</option>
			`;
			}
			cities.innerHTML = options;	
		}
		function findaddress(){
			let options = ``;
			var selectedCityIndex = cities.selectedIndex;
			var selectedCity = res[selectedCityIndex];
				for(var k=0;k<selectedCity.stores.length;k++){
					options +=`
					<option value=${selectedCity.stores[k].Address}>${selectedCity.stores[k].POIName}-${selectedCity.stores[k].Address}</option>
					`;
			}
			addre.innerHTML = options;
		}	
		function getDefault(){
			findcities();
			findaddress();
		}
		cities.addEventListener("change",findaddress)
		
	let homeadd = document.querySelector("#cookiesaddress");
	let saveButton = document.querySelector("#saveButton")

	saveButton.addEventListener("click",function(){
		let storeaddre = document.querySelector('#cookiesstoreaddressee')
	    let storetel = document.querySelector('#cookiesstoretele')
	    let sshipper = document.querySelector('#stores')      
	    let homeaddre = document.querySelector("#cookiesaddressee");
		let hometel = document.querySelector("#cookiestele");
	    let hshipper = document.querySelector('#home');    
	      let value2='';
	        if(storeaddre.value){
	          value2 = storeaddre.value
	        }else if(homeaddre.value){
	          value2=homeaddre.value
	        }
	        document.cookie = "addee="+value2;
	      let value3='';
	        if(storetel.value){
	          value3 = storetel.value
	        }else if(hometel.value){
	          value3=hometel.value
	        }
	        document.cookie = "tel="+value3;
	      let value4='';
	        if(sshipper.checked){
	          value4 = sshipper.value
	        }else if(hshipper.checked){
	          value4=hshipper.value
	        }
	        document.cookie = "shi="+value4;
	      let cash = document.getElementById('cash')
	      let credit = document.getElementById('credit');
	      let value5='';
	        if(credit.checked){
	           value5=credit.value
	        }else if(cash.checked){
	          value5=cash.value
	        }
	        document.cookie = "pay="+value5+";path=/";
        
	let saveadd;
	if(homeadd.value){
		saveadd=homeadd.value
	}else{
		var selectedCityIndex1 = cities.selectedIndex;
		var selectedCity1 = res[selectedCityIndex1];
		var selectedAddress = selectedCity1.stores[addre.selectedIndex].Address
		saveadd=JSON.stringify(selectedAddress)
	}
	document.cookie=`address=${saveadd}`;
	
	
   
		})		
	})
})



		
function uidisplay(result) {
    $(document).ready(function (params) {
        let markup=`<h1>Your score was ${result.score} out of ${result.totalscore}`
        document.querySelector('#resultPage').insertAdjacentHTML('beforebegin',markup);
        for (let i = 0; i < result.wrong.length; i++) {
        	 markup=`<tr><td>${i+1}</td><td>${result.wrong[i].question}</td><td>${result.wrong[i].correct}s</td><td>${result.wrong[i].chosOption}</td></tr>`;
            document.querySelector('#resultPage').insertAdjacentHTML('beforeend',markup);
        }
        markup=`<h3>Total questions Were: ${result.totalscore/2}<h3>`
            document.querySelector('#resultPage').insertAdjacentHTML('afterend',markup);
    });
}
const result=JSON.parse(window.sessionStorage.getItem('state'));
uidisplay(result);
function goVocab(){
	sessionStorage.removeItem("state");
	if(result.page!==undefined)	window.location=getURL()+"/questionvocab";
	else  window.location=getURL()+"/vocab";
}
function getURL(){
	let url=window.location.href;
	urlArr=url.split('/');
	urlArr.pop();
	urlArr.pop();
	url=urlArr.join("/");
	return url;
}
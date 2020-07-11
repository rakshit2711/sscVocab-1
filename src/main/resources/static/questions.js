var state={score:0,options:[],done:false,wrong:[]};

$(document).ready(function (params) {
     let url=getURL();
     url=url+"/question"
    $.ajax({
        url,
        type:"GET",
        dataType:"json",
        success: function name(res) {
            state.res=res;
            state.res.forEach(element => {
                state.options.push(element.meaning);
            });
            state.totalscore=Object.keys(state.res).length *2;
            callquestion();
        },
        error: function(thrownError){
            console.log(thrownError);
        }
    });
});
function callquestion(){
    let data=setquestiondetail(state.res);

    state.curques=data;
    uidisplay(data);
}
function uidisplay(data){
    let markup=`<label for="question" id="question" class="generated">${data.question}</label><br id="br">`;
    document.querySelector('#form').insertAdjacentHTML('afterbegin',markup);
   
    for (let i = 0; i < data.options.length; i++) {
        markup=`<input type="radio" id="option${i}" class="option" name="selectedoption" value="${data.options[i]}">
        <label for="${data.options[i]}" id="optionLabel${i}">${data.options[i]}</label><br>`;
        document.querySelector('#form').insertAdjacentHTML('beforeend',markup);
    }
}
function setquestiondetail(data){
    const setQues={};
    let randques;
    randques =randomNum(data);
    setQues.question=data[randques].word;
    setQues.correct=data[randques].meaning;
    let option=[];
    option[0]=data[randques].meaning;
    var i=1;
    while(i<4){
        let randomnumber=randomNum(state.options);
        let rop=state.options[randomnumber];
         if(rop===option[0]){
            console.log("Same optoina as correct answer found while finding options");
            continue;
        }
        option.push(rop);
        i++;
    }
    setQues.options=randomizeOption(option);
    state.res.splice(randques,1);
    return setQues;
}
function randomNum(data) {
    return Math.floor(Math.random() * data.length);
}
function randomizeOption(option) {
    option.sort(() => Math.random() - 0.5);
    return option;
}
const clearResults=()=> {
    let element = document.getElementById('question');
    element.parentNode.removeChild(element);
    element = document.getElementById('br');
    element.parentNode.removeChild(element);
     for (let i = 0; i < 4; i++) {
        let eleId=`option${i}`;
        element = document.getElementById(eleId);
        element.parentNode.removeChild(element);
        eleId=`optionLabel${i}`;
        element = document.getElementById(eleId);
        element.parentNode.removeChild(element);
     }
     $('#form br').remove();
    
};
function checkAns(){
    const curques=state.curques;
    const x =document.querySelector('input[name="selectedoption"]:checked');
    if(state.done===false){
        if(x){
            const option=x.value;
            if(option===curques.correct){
                setscore(2);
                // alert("Answer is correct Your current score is "+state.score);
            }
            else{
                setscore(-0.5);
                state.curques.chosOption=option;
                state.wrong.push(state.curques);
            }
        }
        else{
                state.curques.chosOption="No Option Chosen";
                state.wrong.push(state.curques);
            // alert("You didn't answer the question "+state.score);
        }
    }

    if(Object.keys(state.res).length === 0){
        state.done=true;
        const result={};
        result.wrong=state.wrong;
        result.score=state.score;
        result.totalscore=state.totalscore;
        result.page="questionvocab;"
        window.sessionStorage.setItem('state',JSON.stringify(result));
        let url=getURL()+"/result";
        window.location=url;
    }
    else{
    nextQues();}
}

function nextQues(){
    if(state.done===false){
        clearResults();
        callquestion();
    }
}

function setscore(value){
    let score=state.score;
        score=score+value;
    state.score=score;
    $(document).ready(function (params) {
        $("#curscore").text(score);
    } );
}
function getURL(){
	let url=window.location.href;
	let urlArr=url.split('/');
	urlArr.pop();
	url=urlArr.join("/");
	return url+"/vocab";
}



$(document).ready(function(){   
    getList(1);
});

function setItemSelect(type,res){

    switch(type){
        case 1:
        case 2:
        case 3: 
        case 4:  
        case 5:
            console.log("set_monument");
            var list_select = document.getElementById("img_monument");
            list_select.src = res;
            break;

        case 6:
        case 7:
        case 8:
        case 14:
            addImg(104,93,res);
            break;
        case 13:
            addImg(30,160,res);
            break;
        default:
            alert( 'Неизвестное значение' );
            break;
    }


}

function addImg(h_set,w_set,res){
    var selectImg = new Konva.Image({
        x: 130,
        y: 140,
        width: w_set,
        height: h_set,
        draggable: true,
        strokeWidth: 10,
    });
    layer.add(selectImg);

    var tr = new Konva.Transformer();
    layer.add(tr);
    var h=true

    selectImg.on('click touchstart', function () {
        if(h){
            h = false
            tr.nodes([selectImg]);
        }else{
            h = true
            tr.nodes([]);
        }
    });

    // selectImg.on('touchmove', function () {
    //     if(h){
    //         h = false
    //         tr.nodes([textNode]);
    //     }else{
    //         h = true
    //         tr.nodes([]);
    //     }
    // });

    var imageObject = new Image();
    imageObject.onload = function () {
        selectImg.image(imageObject);
    };
    imageObject.src = res;
}

function setItemText(type,typeFont){
    var textSelect = ""
    var x_select = 100
    var y_select = 100

    switch(type){
        case 9:
            textSelect = "Фамилия"
            x_select = 130
            y_select = 150
            break;
        case 10:
            textSelect = "Имя"
            x_select = 130
            y_select = 180
            break;
        case 11:
            textSelect = "Отчество"
            x_select = 130
            y_select = 210
            break;
        case 12:
            textSelect = "01.01.1970"
            x_select = 130
            y_select = 240
            break;
    }
    var textNode = new Konva.Text({
        text: textSelect,
        x: x_select,
        y: y_select,
        fontFamily: typeFont,
        fill: 'white',
        fontStyle: 'bold',
        fontSize: 20,
        draggable: true,
        width: 140,
    });

    layer.add(textNode);

    var tr = new Konva.Transformer();
    layer.add(tr);
    var h=true

    textNode.on('click touchstart', function () {
        if(h){
            h = false
            tr.nodes([textNode]);
        }else{
            h = true
            tr.nodes([]);
        }
    });

}


function getList(type){

    var list_select = document.getElementById("list_see_select");
    list_select.innerHTML = '';

    let xhr = new XMLHttpRequest();

    xhr.open('GET', '/getListMonuments?type=' + type, false);


    try {
        xhr.send();
        if (xhr.status != 200) {
            alert(`Ошибка ${xhr.status}: ${xhr.statusText}`);
        } else {
            
            var ListJson = JSON.parse(xhr.response);

            console.log(ListJson[0]);
            if(ListJson.length!==0){
                for(var i=0;i<ListJson.length;i++){
                    var item = ListJson[i]
                    var r = "'" + item.res + "'"
                    var n = "'" + item.name + "'"

                    switch(type){
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            list_select.innerHTML += '<div class="item_select" onclick="setItemSelect(' + item.type + ',' + r + ')"><img src="' + item.res + '" height="60px"></div>'
                            break;
                        case 6:
                            list_select.innerHTML += '<div class="item_select_white_img" onclick="setItemSelect(' + item.type + ',' + r + ')"><img src="' + item.res + '" height="60px"></div>'
                            break;
                        case 7:
                        case 8:
                            list_select.innerHTML += '<div class="item_select" onclick="setItemSelect(' + item.type + ',' + r + ')"><img src="' + item.res + '" height="60px"></div>'
                            break;
                        case 9:
                            list_select.innerHTML += '<div class="item_select_text" style="font-family:' + n + '" onclick="setItemText(9,' + n + ')">Фамилия</div>';
                            break;
                        case 10:
                            list_select.innerHTML += '<div class="item_select_text" style="font-family:' + n + '" onclick="setItemText(10,' + n + ')">Имя</div>';
                            break;
                        case 11:
                            list_select.innerHTML += '<div class="item_select_text" style="font-family:' + n + '" onclick="setItemText(11,' + n + ')">Отчество</div>';
                            break;
                        case 12:
                            list_select.innerHTML += '<div class="item_select_text" style="font-family:' + n + '" onclick="setItemText(12,' + n + ')">01.01.1970</div>';
                            break;
                        case 13:
                            list_select.innerHTML += '<div class="item_select_white_text" onclick="setItemSelect(' + item.type + ',' + r + ')"><img src="' + item.res + '" width="200px"></div>'
                            break;
                        case 14:
                            list_select.innerHTML += '<div class="item_select_white_img" onclick="setItemSelect(' + item.type + ',' + r + ')"><img src="' + item.res + '" height="60px"></div>'
                            break;

                    }

                    
                }
            }
        }
    } catch(err) { // для отлова ошибок используем конструкцию try...catch вместо onerror
        alert("Запрос не удался");
    }

}
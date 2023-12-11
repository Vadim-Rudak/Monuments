let listItem1 = [
    {id: 1 , name: "Вертикальные"},
    {id: 2 , name: "Горизонтальные"},
    {id: 3 , name: "Фигурные"},
    {id: 4 , name: "Арки"},
    {id: 5 , name: "Резные"}
];

let listItem2 = [
    {id: 6 , name: "Гравировка"},
    {id: 7 , name: "Фотокерамика"},
    {id: 8 , name: "Табличка"}
];

let listItem3 = [
    {id: 9 , name: "Фамилия"},
    {id: 10 , name: "Имя"},
    {id: 11 , name: "Отчество"},
    {id: 12 , name: "Даты"}
];

let listItem4 = [
    {id: 13 , name: "Эпитафия"},
    {id: 14 , name: "С изображением"}
];

let listItem5 = [
    {id: 15 , name: "Церкви"},
    {id: 16 , name: "Иконы"},
    {id: 17 , name: "Ангелы"},
    {id: 18 , name: "Христианство"},
    {id: 19 , name: "Свечи"},
    {id: 20 , name: "Кресты"}
];

$(document).ready(function(){
    setInHtml(listItem1);
});


function getListToSelect(itemSelect){
    var list_to_select = document.getElementById("btns_use_k");
    list_to_select.innerHTML = "";

    switch(itemSelect){
        case "item_1":
            console.log("Changed to=>: 1 ");
            setInHtml(listItem1);
            break;
        case "item_2":
            console.log("Changed to=>: 2");
            setInHtml(listItem2);
            break;
        case "item_3":
            console.log("Changed to=>: 3");
            setInHtml(listItem3);
            break;
        case "item_4":
            console.log("Changed to=>: 4");
            setInHtml(listItem4);
            break;
        case "item_5":
            console.log("Changed to=>: 5");
            setInHtml(listItem5);
            break;
        default:
            console.log("Changed to=>: 0");
            setInHtml(listItem1);
            break;
    }
}

function setInHtml(useList){
    var list_to_select = document.getElementById("btns_use_k");
    list_to_select.innerHTML = "";

    for(const element of useList){
        list_to_select.innerHTML += '<button class="dropbtn" onclick="getList(' + element.id +')">' + element.name + '</button>';
    }

}


function saveFile(){
    console.log("save");
}
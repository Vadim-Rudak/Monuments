
fetch('/getInfoGraf2', {
    method: 'GET'
  })
  .then(function(response) { return response.json(); })
  .then(function(json) {
    
    // chart colors
    var colors = ['#66C2A5','#3288BD','#5e4fa2'];

    /* 3 donut charts */
    var donutOptions = {
    cutoutPercentage: 85, 
    legend: {position:'bottom', padding:5, labels: {pointStyle:'circle', usePointStyle:true}}
    };

    // donut 2
    var chDonutData2 = {
        labels: ['Главная','Каталог','Конструктор'],
        datasets: [
        {
            backgroundColor: colors.slice(0,3),
            borderWidth: 0,
            data: [json[0],json[1],json[2]]
        }
        ]
    };
    var chDonut2 = document.getElementById("chDonut2");
    if (chDonut2) {
    new Chart(chDonut2, {
        type: 'pie',
        data: chDonutData2,
        options: donutOptions
    });
    }

});
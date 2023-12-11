// chart colors
var colors1 = ['#007bff','#28a745','#333333','#c3e6cb','#dc3545','#6c757d'];

/* large line chart */
var chLine = document.getElementById("chLine");
var chartData;

fetch('/getInfoGraf1', {
  method: 'GET'
})
.then(function(response) { return response.json(); })
.then(function(json) {
    
    chartData = {
        labels: [json[0].nameDay, json[1].nameDay, json[2].nameDay, json[3].nameDay, json[4].nameDay, json[5].nameDay, json[6].nameDay],
        datasets: [{
            data: [json[0].people, json[1].people, json[2].people, json[3].people, json[4].people, json[5].people, json[6].people],
            backgroundColor: 'transparent',
            borderColor: colors1[0],
            borderWidth: 4,
            pointBackgroundColor: colors1[0]
        }]
    };

    if (chLine) {
        new Chart(chLine, {
        type: 'line',
        data: chartData,
        options: {
            scales: {
            xAxes: [{
                ticks: {
                beginAtZero: false
                }
            }]
            },
            legend: {
            display: false
            },
            responsive: true
        }
        });
        }
  // use the json
});


//   {
//     data: [639, 465, 493, 478, 589, 632, 674],
//     backgroundColor: colors[3],
//     borderColor: colors[1],
//     borderWidth: 4,
//     pointBackgroundColor: colors[1]
//   }

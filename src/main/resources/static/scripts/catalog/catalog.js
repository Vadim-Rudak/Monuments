function PopUpAddTaskShow(id){
    var id_elem =  document.getElementById("id_elem");
    id_elem.textContent = id;
    document.getElementById("task_fio").value = "";
    document.getElementById("task_phone").value = "";
    document.getElementById("task_more_info").value = "";

    document.getElementById("coopPopUpAddTask").style.display = "flex";
}

async function sendTaskToServer(){
    var id = document.getElementById("id_elem").textContent;
    var fio = document.getElementById("task_fio").value;
    var phone = document.getElementById("task_phone").value;
    var more_info = document.getElementById("task_more_info").value;

    var data = new FormData();
    await data.append('id_element', id);
    await data.append('all_name', fio);
    await data.append('phone_number', phone);
    await data.append('more_info', more_info);
    

    let response = await fetch('/add_task', {
        method: 'POST',
        body: data
    });
  
      let result = await response.json();
      console.log(result);
      PopUpAddTaskHide();
      PopUpMessageShow();

}

function PopUpAddTaskHide(){
    document.getElementById("coopPopUpAddTask").style.display = "none";
}


function PopUpMessageShow(){
    document.getElementById("coopPopUpMessage").style.display = "flex";
}

function PopUpMessageHide(){
    document.getElementById("coopPopUpMessage").style.display = "none";
}
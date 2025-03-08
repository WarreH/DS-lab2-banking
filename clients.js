
const BASE_URL = (process.env.BASE_URL || "http://localhost:8080") +"/api/balance";
async function put(url,body) {
    const request = new Request(url, {
        method: "PUT",
        body: JSON.stringify(body),
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
    });
    await fetch(request);
}
async function get(url){
    const request = new Request(url, {
        method: "GET"
    });

    const response = await  fetch(request);
    return await response.json();
}
async function client(id){
    // Update balance 10 times
    let totalAmount = 0;
    for(let i =0;i<10;i++){
        const amount = 100*(i%3)
        await put(BASE_URL+"/increase/"+id,{
            balance:amount
        });
        totalAmount += amount;
    }
    console.log("Deposited: "+totalAmount)
}

async function multiClient(){
    // Wait 5 seconds to give the server time to boot
    await new Promise(resolve => setTimeout(resolve, 5000));
    console.log("Start requesting");

    const id = 500;
    await Promise.all([
        client(id),
        client(id)
    ])
    const newBalance = await get(BASE_URL+"/"+id)
    console.log("New balance: "+newBalance.balance);
}
multiClient();
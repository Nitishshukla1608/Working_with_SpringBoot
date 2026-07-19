import { useState } from "react";
import axios from "axios";

function Payment() {

    const [amount, setAmount] = useState("");

    const handlePayment = async () => {

        if (!amount || amount <= 0) {
            alert("Please enter a valid amount.");
            return;
        }

        console.log("Button Clicked");

        try {

            const response = await axios.post(
                "http://localhost:8080/api/payments/create",
                null,
                {
                    params: {
                        amount: amount,
                        currency: "INR"
                    }
                }
            );

            console.log("Response:", response.data);

            const order = response.data;

            const options = {
                key: "rzp_test_TESZcTJrpjOmns",
                amount: order.amount,
                currency: order.currency,
                name: "TaskFlow",
                description: "Spring Boot + React Demo",
                order_id: order.id,

                handler: function (response) {

                    console.log("Payment Success:", response);

                    alert("Payment Successful!");
                    alert("Payment ID: " + response.razorpay_payment_id);
                },

                prefill: {
                    name: "Nitish",
                    email: "test@example.com",
                    contact: "9999999999"
                },

                theme: {
                    color: "#3399cc"
                },

                modal: {
                    ondismiss: function () {
                        console.log("Checkout Closed");
                    }
                }
            };

            console.log("Opening Razorpay...");
            console.log(window.Razorpay);

            const razorpay = new window.Razorpay(options);

            razorpay.on("payment.failed", function (response) {
                console.log("Payment Failed");
                console.log(response.error);
            });

            razorpay.open();

        } catch (error) {
            console.error("Error:", error);
        }
    };

    return (
        <div
            style={{
                marginTop: "100px",
                textAlign: "center"
            }}
        >
            <h1>Razorpay Demo</h1>

            <input
                type="number"
                placeholder="Enter Amount"
                value={amount}
                onChange={(e) => setAmount(e.target.value)}
                style={{
                    padding: "10px",
                    width: "200px",
                    marginRight: "10px"
                }}
            />

            <button onClick={handlePayment}>
                Pay ₹{amount || 0}
            </button>
        </div>
    );
}

export default Payment;
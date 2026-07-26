import { useState } from "react";
import axios from "axios";

function Payment() {
    const [amount, setAmount] = useState("");

    const handlePayment = async () => {
        if (!amount || amount <= 0) {
            alert("Please enter a valid amount.");
            return;
        }

        try {
            const response = await axios.post(
                "http://localhost:8080/api/payments/create",
                null,
                {
                    params: {
                        amount: amount,
                        currency: "INR",
                    },
                }
            );

            const order = response.data;

            const options = {
                key: "rzp_test_TESZcTJrpjOmns",
                amount: order.amount,
                currency: order.currency,
                name: "TaskFlow",
                description: "Spring Boot + React Demo",
                order_id: order.id,

                handler: function (response) {
                    alert("✅ Payment Successful!");
                    alert("Payment ID: " + response.razorpay_payment_id);
                },

                prefill: {
                    name: "Nitish",
                    email: "test@example.com",
                    contact: "9999999999",
                },

                theme: {
                    color: "#635BFF",
                },
            };

            const razorpay = new window.Razorpay(options);

            razorpay.on("payment.failed", function (response) {
                alert(response.error.description);
            });

            razorpay.open();
        } catch (error) {
            console.error(error);
            alert("Something went wrong!");
        }
    };

    return (
        <div
            style={{
                height: "100vh",
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                background:
                    "linear-gradient(135deg,#667eea 0%, #764ba2 100%)",
                fontFamily: "Arial",
            }}
        >
            <div
                style={{
                    width: "380px",
                    background: "#fff",
                    borderRadius: "20px",
                    padding: "35px",
                    boxShadow: "0 15px 40px rgba(0,0,0,0.25)",
                    textAlign: "center",
                }}
            >
                <img
                    src="https://cdn-icons-png.flaticon.com/512/2489/2489756.png"
                    alt="Payment"
                    width="90"
                    style={{ marginBottom: "15px" }}
                />

                <h1
                    style={{
                        marginBottom: "10px",
                        color: "#333",
                    }}
                >
                    Razorpay Payment
                </h1>

                <p
                    style={{
                        color: "#777",
                        marginBottom: "25px",
                    }}
                >
                    Secure payment powered by Razorpay
                </p>

                <input
                    type="number"
                    placeholder="Enter Amount"
                    value={amount}
                    onChange={(e) => setAmount(e.target.value)}
                    style={{
                        width: "100%",
                        padding: "14px",
                        fontSize: "17px",
                        borderRadius: "10px",
                        border: "1px solid #ddd",
                        outline: "none",
                        marginBottom: "25px",
                        boxSizing: "border-box",
                    }}
                />

                <button
                    onClick={handlePayment}
                    style={{
                        width: "100%",
                        padding: "15px",
                        background: "#635BFF",
                        color: "#fff",
                        fontSize: "18px",
                        fontWeight: "bold",
                        border: "none",
                        borderRadius: "10px",
                        cursor: "pointer",
                        transition: "0.3s",
                    }}
                    onMouseOver={(e) =>
                        (e.target.style.background = "#5145CD")
                    }
                    onMouseOut={(e) =>
                        (e.target.style.background = "#635BFF")
                    }
                >
                    💳 Pay ₹ {amount || 0}
                </button>

                <div
                    style={{
                        marginTop: "20px",
                        fontSize: "14px",
                        color: "#888",
                    }}
                >
                    🔒 100% Secure Payments
                </div>
            </div>
        </div>
    );
}

export default Payment;
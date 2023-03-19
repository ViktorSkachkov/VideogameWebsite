import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import axios from "axios";
import Cookies from "universal-cookie";

const ViewAddition = (loggedUser) => {
    const [addition, setAddition] = useState(null);
    const [review, setReview] = useState(null);
    let params = useParams();
    const id = params.id;

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    useEffect(() => {
        getAddition();
    }, []);
    const handleSubmit = (e) => {

    };
    const getAddition = () => {
        var config = {
            method: "get",
            url: `http://localhost:8080/additions/${id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config)
            .then(function (response) {
                setAddition(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    };
    const onChangeReview = event => {
        setReview(event.target.value);
    }
    return (
        <>
            {addition != null ?
                <div className="viewGameBody">
                    <center>
                        <img src="/69piR5.jpg" width="80%" height="400px"  alt="Currently the image can't load"/>
                        <h1>{addition.name}</h1>
                        <p>{addition.description}</p>
                        <button>Add</button>
                        <form onSubmit={handleSubmit}>
                            <label htmlFor="review" className="review">Review</label><br/>
                            <input onChange={onChangeReview} name="review" type="number" className="Label"/><br/>
                            <button>Submit Review</button><br/><br/>
                        </form>
                    </center>
                </div> :
                <p>Loading...</p>}
        </>
    )
}
export default ViewAddition;
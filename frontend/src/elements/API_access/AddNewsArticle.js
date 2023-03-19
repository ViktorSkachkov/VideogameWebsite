import axios from "axios";
import {useState} from "react";
import Cookies from "universal-cookie";

const AddNewsArticle = (loggedUser) => {
    const [gameId, setGameId] = useState(1);
    const [image, setImage] = useState("image");
    const [title, setTitle] = useState();
    const [text, setText] = useState();

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    const onChangeText = event => {
        setText(event.target.value);
    }
    const onChangeImage = event => {
        var reader = new FileReader();
        reader.onload = function (event) {
            setImage(event.target.result);
        };
        reader.readAsDataURL(event.target.files[0]);
    }
    const onChangeTitle = event => {
        setTitle(event.target.value);
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        const config = {
            headers: { Authorization: `Bearer ${token}` }
        };
        const bodyParams = {
            "id": 1,
            "gameId": gameId,
            "image": image,
            "text": text,
            "title": title,
        };
        axios.post(
            `http://localhost:8080/news`,
            bodyParams,
            config
        )
            .then(function (response) {
                /*let mealName = response.data.mealName;
                navigate(`/successfullyUpdatedMeal/${mealName}`);*/
                alert('News article successfully added!');
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    return (
        <>
            <center>
                <form onSubmit={handleSubmit}>
                    <br/><br/>
                    <label htmlFor="image" className="formLabelImage">Image</label><br/><br/>
                    <input type="file" name="image" onChange={onChangeImage} className="Label"/><br/><br/>
                    <label htmlFor="name" className="formLabelName">Title</label><br/>
                    <input type="text" name="title" onChange={onChangeTitle} value={title} className="Label" /><br/><br/>
                    <label htmlFor="text" className="formLabelText">Text</label><br/>
                    <textarea type="text" name="text" onChange={onChangeText} value={text} className="Label" /><br/><br/>
                    <button type="submit" className="normalButton">Submit</button>
                </form><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </center>
        </>
    )
}
export default AddNewsArticle;
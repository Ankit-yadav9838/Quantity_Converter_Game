import React, { useState, useEffect } from 'react';
import { Button, MenuItem, Select, TextField, Typography, Box } from '@mui/material';

function App() {
  const [converters, setConverters] = useState([]);
  const [selected, setSelected] = useState('');
  const [inputVal, setInputVal] = useState('');
  const [result, setResult] = useState('');
  const [userAnswer, setUserAnswer] = useState('');
  const [feedback, setFeedback] = useState('');
  const [score, setScore] = useState(0);

  useEffect(() => {
    fetch('/api/game/converters')
      .then(res => res.json())
      .then(data => setConverters(data))
      .catch(e => console.error(e));
  }, []);

  const convert = () => {
    fetch('/api/game/convert', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({type: selected, value: parseFloat(inputVal)}),
    })
    .then(res => res.json())
    .then(data => {
      if (data.error) {
        setResult(data.error);
      } else {
        setResult(`Result: ${data.result} (${data.unit})`);
        setFeedback('');
      }
    })
    .catch(() => setResult('Conversion Error'));
  };

  const checkAnswer = () => {
    fetch('/api/game/answer', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({
        type: selected,
        value: parseFloat(inputVal),
        userAnswer: parseFloat(userAnswer)
      }),
    })
    .then(res => res.json())
    .then(data => {
      if (data.correct) setFeedback('🎉 Correct! +10 points');
      else setFeedback(`❌ Incorrect. Correct answer is ${data.actual}`);
      setScore(data.score);
    })
    .catch(() => setFeedback('Error checking answer'));
  };

  return (
    <Box sx={{ width:400, margin:'40px auto', textAlign:'center', padding:4, boxShadow:3, bgcolor:'white', borderRadius:3 }}>
      <Typography variant="h4" color="primary">Converter Game</Typography>
      <Box sx={{mt:2}}>
        <Select value={selected} onChange={e => setSelected(e.target.value)} fullWidth displayEmpty>
          <MenuItem value="">Select Converter</MenuItem>
          {converters.map(c => (
            <MenuItem key={c} value={c}>{c}</MenuItem>
          ))}
        </Select>
      </Box>
      <TextField label="Enter Value" type="number" fullWidth sx={{mt:2}} value={inputVal} onChange={e => setInputVal(e.target.value)} />
      <Button variant="contained" sx={{mt:2}} disabled={!selected || !inputVal} onClick={convert}>Convert</Button>
      <Typography sx={{mt:2}}>{result}</Typography>
      <TextField label="Your Guess?" type="number" fullWidth sx={{mt:2}} value={userAnswer} onChange={e => setUserAnswer(e.target.value)} />
      <Button variant="contained" color="secondary" sx={{mt:2}} disabled={!userAnswer} onClick={checkAnswer}>Check</Button>
      <Typography sx={{mt:2, fontWeight:'bold'}} color="success.main">{feedback}</Typography>
      <Typography sx={{mt:2}}>Score: {score}</Typography>
    </Box>
  );
}

export default App;

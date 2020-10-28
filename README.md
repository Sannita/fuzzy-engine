# fuzzy-engine
Fuzzy Logic engine
## processo
1-Individuare le variabili di I/O del sistema con i rispettivi range

Input:

Distanza \[-100,100\] m

Velocità \[-60,60\] m/s

Output:

Frenata \[0,10\] m/s^2

Accelerazione \[-10, 10\] m/s^2

2-Determinare le classi di appartenza di ogni variabile con i rispettivi boundaries

![classi](https://github.com/Sannita/fuzzy-engine/blob/main/image.jpg?raw=true)

3-Definire le trasformazioni tramite FAM

Se la distanza è piccola E la velocità è grande Allora la frenata è forte

4-Modalità di defuzzyfication

## spiegazione

Le classi di appartenenza sono rappresenta generalmente da funzioni triangolari o trapezoidali con il valore massimo pari a 1. Dato un valore di x restituiscono il grado di appartenenza ad una determinata classe A, m(A) compreso nell'intervallo chiuso \[0,1\]

Le regole FAM sono basate su AND, OR, NOT e combinazioni delle diverse classi secondo le seguenti regole:

- A and B= min(m(A), m(B))

- A or B = max(m(A), m(B))

- NOT A = 1 - m(A)

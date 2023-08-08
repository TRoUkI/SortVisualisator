# Visualisation of sorting
A sorting visualization app written in Java/JavaFX and ability to add new sorting algorithms by inherritence and modification.

<img src="https://github.com/TRoUkI/SortVisualisator/assets/47295089/b580b282-5038-4e1d-bda1-358c37ebaadd" width="300">
<img src="https://github.com/TRoUkI/SortVisualisator/assets/47295089/602beac7-a008-4869-bff4-9b3401e17cef" width="300">
<img src="https://github.com/TRoUkI/SortVisualisator/assets/47295089/e65185a1-b29c-4113-88b8-e2d30bd91758" width="300">

![2023-06-22 20-24-17](https://github.com/TRoUkI/SortVisualisator/assets/47295089/a8e530d8-29e6-45d7-ad4b-e2e5fb5e173e)

## Instruction for creating your own algorithm:
- Your algorithm should be added to package `src/main/java/algorithms`.
- Algorithm should inherrit `AlgorithmAbstractFX`.
- `AlgorithmBody` function uses for activating algorithm.
- Program uses array of `RectangleClass rectangleArray`, for sorting and visualising.
- Utility Class `RectangleClass` extends Rectangle, with custom function for comparasing `RectangleClass` objects.

##### For starting Visual program execute project, choose algorithm and press **START SORTING** 
##### For starting text program run test from chosen Algorithm in package `test/java/alorithm`. You can configure array size by changing size in `AlgorithmAbstract` class.

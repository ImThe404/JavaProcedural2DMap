# An java procedural 2D map using perlin noise

![](/gifMap.gif)

The objective of the project is to have a easy to use procedural map in java using a Perlin noise map. 
The map can be easly modify using the variables and the differants color in the color map can be change using buttons.
To see more informations on how change settings see the rubric down bellow.

### 2 Buttons :

#### Noise map 

Use to switch to the noise map, where you can see the variance of gray get from the perlin noise algorithm.

#### Color map

Use to switch to the color map, where the color pixel are place in function of the float from the noise map.

### Differants settings explain :

`seed`

This variable represents the seed of the map and can be use to made a large number of differants map.

`scale`

This variable represents how much you gonna "zoom" in the map. the map is recalculate in evry scale and does
not just increase pixel size.

`octaves`

This variable represents how much you gonna apply the algotithm. It can be feel as how much detail you put.
The first octave add the form, then the second add the path ect...

`persistance`

This variable represents the power with which the ground is gonna be smooth.

`lacunarity`

This variable represents the power to which the shapes is gonna be round.

`offsetX`

This variable represents the shifts to east and west, on the x axis

`offsetY`

This variable represents the shifts to north and south, on the y axis

### How to change color and height ?

To change the number of color, the color and the pourcentage of color you want to see, you can change it pretty easly.

#### Change the number of color

This parameters is more difficult to change and need to be change in the code, just remove the TerrainType you 
don't want in the file `MainFrame`.

#### Change the color

You can change the color by simply click on the buttons affect by the color and a new frame is gonna open.
by then just click the color you want and press ok, or if the don't find what you want, press cancel.

#### Change the height/name

You can change the pourcentage of how much you see each color by changing the height. The color will be paint
of every pixel that have a value between the previous color and the height. 
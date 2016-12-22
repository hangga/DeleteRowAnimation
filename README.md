# DeleteRowAnimation
Efek animasi hapus childview pada LinearLayout.  
```
private void addItem(){
     final Child child = new Child(MainActivity.this, colorlist.get(new Random().nextInt(Warna.length)));

     child.getImgDelete().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteRowAnimation anim = new DeleteRowAnimation(child);
                anim.setDuration(1000);
                child.startAnimation(anim);
            }
     });
     linMain.addView(child);
}
    
    
    
for (int i = 0; i < 20; i++){
     addItem();
}
    
```
#SWIPE LEFT
```
DeleteRowAnimation anim = new DeleteRowAnimation(child);
anim.setAnimType(DeleteRowAnimation.SWIPE_LEFT);
anim.setDuration(1000);
child.startAnimation(anim);
```

![alt tag](https://github.com/hangga/DeleteRowAnimation/blob/master/delete-row_1.gif)

#ALPHA
```
DeleteRowAnimation anim = new DeleteRowAnimation(child);
anim.setAnimType(DeleteRowAnimation.ALPHA);
anim.setDuration(1000);
child.startAnimation(anim);
```
![alt tag](https://github.com/hangga/DeleteRowAnimation/blob/master/delete-row-alpha.gif)

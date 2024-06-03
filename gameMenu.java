import greenfoot.*;  // atau package yang sesuai

public class gameMenu extends World {
    public int currentSelection = 0;
    private GreenfootImage[] menuImages = new GreenfootImage[5];
    private MenuOption[] menuOptions = new MenuOption[5];
    private GreenfootSound backsoundStart;
    
    private boolean keyDownPressed = false;
    private boolean keyUpPressed = false;
    private int timer = 0;

    Counter counter = new Counter();    
    Highscore highscore = new Highscore();
    
    public gameMenu() {
        super(600, 400, 1);  
        prepare();
    }

    private void prepare() {

        int initialX = getWidth() / 2;
        int initialY = getHeight() / 2-30;
        int spacing = 40;

        // Inisialisasi gambar-gambar menu
        menuImages[0] = new GreenfootImage("menu_start.png");
        menuImages[1] = new GreenfootImage("menu_instructions.png");
        menuImages[2] = new GreenfootImage("menu_credits.png");
        menuImages[3] = new GreenfootImage("menu_settings.png");
        menuImages[4] = new GreenfootImage("menu_quit.png");

        for (int i = 0; i < 5; i++) {
            menuOptions[i] = new MenuOption(menuImages[i], initialX, initialY + spacing * i);
            addObject(menuOptions[i], initialX, initialY + spacing * i);
        }
        updateSelection();
    }

    public void act() {
        timer++;
        checkKeyPress();
    }

    private void checkKeyPress() {
        if (Greenfoot.isKeyDown("down")) {
            if (!keyDownPressed) {
                currentSelection = (currentSelection + 1) % menuOptions.length;
                updateSelection();
                keyDownPressed = true;
            }
        } else {
            keyDownPressed = false;
        }

        if (Greenfoot.isKeyDown("up")) {
            if (!keyUpPressed) {
                currentSelection = (currentSelection - 1 + menuOptions.length) % menuOptions.length;
                updateSelection();
                keyUpPressed = true;
            }
        } else {
            keyUpPressed = false;
        }

        if (timer > 5 && Greenfoot.isKeyDown("space")) {
            selectOption();
        }
    }

    private void updateSelection() {
        for (int i = 0; i < menuOptions.length; i++) {
            if (i == currentSelection) {
                menuOptions[i].setSelected(true);
            } else {
                menuOptions[i].setSelected(false);
            }
        }
    }
    private void selectOption() {
        if (currentSelection == 0) {
            // Pindah ke lapisan permainan
            Greenfoot.setWorld(new gameStory()); // Ganti dengan kelas dunia permainan Anda
            backsoundStart = new GreenfootSound("start.mp3");
            backsoundStart.setVolume(70);
            backsoundStart.play();
        } else if (currentSelection == 1) {
            // Pindah ke tampilan cara bermain
            Greenfoot.setWorld(new gameInstruction());
        } else if (currentSelection == 2) {
            // Pindah ke tampilan credits
            Greenfoot.setWorld(new gameCredits());
        } else if(currentSelection == 3) {
            // Pindah ke tampilan setting
            Greenfoot.setWorld(new gameSettings());
        } else{
            // Keluar dari permainan
            highscore.putScore(Integer.MAX_VALUE);
            Greenfoot.stop();
        }
    }
}



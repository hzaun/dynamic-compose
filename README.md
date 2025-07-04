A simple app to showcase dynamic UI creation using Jetpack Compose

#### Constrained Buttons

<img width="280" alt="Screenshot 2025-07-05 at 2 30 48 AM" src="https://github.com/user-attachments/assets/db70378c-8819-48eb-825d-c5d0555dbe5d" />

<details>
<summary>
JSON Input:
</summary>
<br>

```json
[
  {
    "id": "b1",
    "text": "Text 1",
    "backgroundColor": "#d2acf5",
    "textColor": "#ffffff",
    "viewType": "BUTTON",
    "constraintLinks": {
      "left": {
        "target": "parent",
        "anchor": "LEFT"
      },
      "top": {
        "target": "parent",
        "anchor": "TOP"
      }
    }
  },
  {
    "id": "b2",
    "text": "Text 2",
    "backgroundColor": "#0095ff",
    "textColor": "#ffffff",
    "viewType": "BUTTON",
    "constraintLinks": {
      "left": {
        "target": "b1",
        "anchor": "RIGHT",
        "margin": 16
      },
      "top": {
        "target": "b1",
        "anchor": "TOP"
      }
    }
  }
]
```
</details>

#### Complex UI

<img width="299" alt="Screenshot 2025-07-05 at 2 32 50 AM" src="https://github.com/user-attachments/assets/94da7d74-a338-4b75-87e3-833c35e307d2" />

<details>
<summary>
JSON Input:
</summary>
<br>

```json
[
  {
    "id": "t1",
    "name": "Text 1",
    "text": "Title",
    "typography": "TITLE",
    "padding": 4,
    "backgroundColor": "#d2acf5",
    "textColor": "#ffffff",
    "viewType": "TEXT",
    "constraintLinks": {
      "left": {
        "target": "parent",
        "anchor": "LEFT"
      },
      "top": {
        "target": "parent",
        "anchor": "TOP"
      }
    }
  },
  {
    "id": "t2",
    "name": "Text 2",
    "text": "Subtitle",
    "typography": "SUBTITLE1",
    "padding": 4,
    "backgroundColor": "#0095ff",
    "textColor": "#ffffff",
    "viewType": "TEXT",
    "constraintLinks": {
      "left": {
        "target": "t1",
        "anchor": "LEFT",
        "margin": "16.0"
      },
      "top": {
        "target": "t1",
        "anchor": "BOTTOM"
      }
    }
  },
  {
    "id": "t3",
    "name": "Text 3",
    "text": "Description: Lorem ipsum dolor sit amet",
    "padding": 4,
    "backgroundColor": "#837cec",
    "textColor": "#ffffff",
    "viewType": "TEXT",
    "constraintLinks": {
      "left": {
        "target": "t2",
        "anchor": "LEFT",
        "margin": "16.0"
      },
      "top": {
        "target": "t2",
        "anchor": "BOTTOM"
      }
    }
  },
  {
    "id": "b1",
    "name": "Some Action",
    "text": "Clicky",
    "backgroundColor": "#49eec7",
    "textColor": "#ffffff",
    "viewType": "BUTTON",
    "action": "NAVIGATE",
    "constraintLinks": {
      "top": {
        "target": "t2",
        "anchor": "TOP"
      },
      "right": {
        "target": "parent",
        "anchor": "RIGHT",
        "margin": "16.0"
      }
    }
  },
  {
    "id": "b2",
    "name": "Some Action",
    "text": "!1!",
    "backgroundColor": "#8a2a8e",
    "textColor": "#ffffff",
    "viewType": "BUTTON",
    "action": "NAVIGATE",
    "constraintLinks": {
      "left": {
        "target": "parent",
        "anchor": "LEFT"
      },
      "top": {
        "target": "t2",
        "anchor": "TOP"
      },
      "right": {
        "target": "parent",
        "anchor": "RIGHT"
      }
    }
  },
  {
    "id": "b3",
    "name": "Some Action",
    "text": "!2!",
    "backgroundColor": "#038c81",
    "textColor": "#ffffff",
    "viewType": "BUTTON",
    "action": "NAVIGATE",
    "constraintLinks": {
      "left": {
        "target": "parent",
        "anchor": "LEFT"
      },
      "top": {
        "target": "parent",
        "anchor": "TOP"
      },
      "right": {
        "target": "parent",
        "anchor": "RIGHT"
      }
    }
  },
  {
    "id": "b4",
    "name": "Some Action",
    "text": "!3!",
    "backgroundColor": "#adbadb",
    "textColor": "#ffffff",
    "viewType": "BUTTON",
    "action": "NAVIGATE",
    "constraintLinks": {
      "left": {
        "target": "parent",
        "anchor": "LEFT"
      },
      "top": {
        "target": "parent",
        "anchor": "TOP",
        "margin": "120.0"
      },
      "right": {
        "target": "parent",
        "anchor": "RIGHT"
      }
    }
  },
  {
    "id": "l1",
    "name": "Layout",
    "backgroundColor": "#efefef",
    "viewType": "LAYOUT",
    "action": "NAVIGATE",
    "constraintLinks": {
      "left": {
        "target": "parent",
        "anchor": "LEFT"
      },
      "top": {
        "target": "t3",
        "anchor": "BOTTOM",
        "margin": "16.0"
      },
      "right": {
        "target": "parent",
        "anchor": "RIGHT"
      },
      "bottom": {
        "target": "parent",
        "anchor": "BOTTOM"
      }
    },
    "children": [
      {
        "id": "t1",
        "name": "Text 1",
        "text": "Title",
        "typography": "TITLE",
        "padding": 4,
        "backgroundColor": "#d2acf5",
        "textColor": "#ffffff",
        "viewType": "TEXT",
        "constraintLinks": {
          "left": {
            "target": "parent",
            "anchor": "LEFT"
          },
          "top": {
            "target": "parent",
            "anchor": "TOP"
          }
        }
      },
      {
        "id": "t2",
        "name": "Text 2",
        "text": "Subtitle",
        "typography": "SUBTITLE1",
        "padding": 4,
        "backgroundColor": "#0095ff",
        "textColor": "#ffffff",
        "viewType": "TEXT",
        "constraintLinks": {
          "left": {
            "target": "t1",
            "anchor": "LEFT",
            "margin": "16.0"
          },
          "top": {
            "target": "t1",
            "anchor": "BOTTOM"
          }
        }
      },
      {
        "id": "t3",
        "name": "Text 3",
        "text": "Description: Lorem ipsum dolor sit amet",
        "padding": 4,
        "backgroundColor": "#837cec",
        "textColor": "#ffffff",
        "viewType": "TEXT",
        "constraintLinks": {
          "left": {
            "target": "t2",
            "anchor": "LEFT",
            "margin": "16.0"
          },
          "top": {
            "target": "t2",
            "anchor": "BOTTOM"
          }
        }
      },
      {
        "id": "l2",
        "name": "Layout",
        "backgroundColor": "#232323",
        "viewType": "LAYOUT",
        "action": "NAVIGATE",
        "constraintLinks": {
          "left": {
            "target": "parent",
            "anchor": "LEFT"
          },
          "top": {
            "target": "t3",
            "anchor": "BOTTOM",
            "margin": "16.0"
          },
          "right": {
            "target": "parent",
            "anchor": "RIGHT"
          },
          "bottom": {
            "target": "parent",
            "anchor": "BOTTOM"
          }
        },
        "children": [
          {
            "id": "t1",
            "name": "Text 1",
            "text": "Title",
            "typography": "TITLE",
            "padding": 4,
            "backgroundColor": "#d2acf5",
            "textColor": "#ffffff",
            "viewType": "TEXT",
            "constraintLinks": {
              "left": {
                "target": "parent",
                "anchor": "LEFT"
              },
              "top": {
                "target": "parent",
                "anchor": "TOP"
              }
            }
          },
          {
            "id": "t2",
            "name": "Text 2",
            "text": "Subtitle",
            "typography": "SUBTITLE1",
            "padding": 4,
            "backgroundColor": "#0095ff",
            "textColor": "#ffffff",
            "viewType": "TEXT",
            "constraintLinks": {
              "left": {
                "target": "t1",
                "anchor": "LEFT",
                "margin": "16.0"
              },
              "top": {
                "target": "t1",
                "anchor": "BOTTOM"
              }
            }
          },
          {
            "id": "t3",
            "name": "Text 3",
            "text": "Description: Lorem ipsum dolor sit amet",
            "padding": 4,
            "backgroundColor": "#837cec",
            "textColor": "#ffffff",
            "viewType": "TEXT",
            "constraintLinks": {
              "left": {
                "target": "t2",
                "anchor": "LEFT",
                "margin": "16.0"
              },
              "top": {
                "target": "t2",
                "anchor": "BOTTOM"
              }
            }
          }
        ]
      }
    ]
  }
]
```
</details>
